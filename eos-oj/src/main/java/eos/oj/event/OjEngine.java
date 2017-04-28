package eos.oj.event;

import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDao;
import eos.oj.dao.TopicDataValidationDao;
import eos.oj.entity.Topic;
import eos.oj.entity.TopicDataValidation;
import eos.oj.enums.ResultStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mr_yyy on 2017/4/24.
 * OJ引擎
 */
@Slf4j
@Service
public class OjEngine {

    private static final String JAVA_SUFFIX = ".java";

    private static final String CLASS_SUFFIX = ".class";

    private static final String SOLUTION_METHOD = "solution";

    private static final ReentrantLock commitlock = new ReentrantLock();

    private static final ReentrantLock aclock = new ReentrantLock();

    private static final String SOLUTION_CLASS = "import java.lang.*; import java.util.*; public class " ;

    @Autowired
    private TopicDataValidationDao topicDataValidationDao;

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private TopicDao topicDao;

    public void run(File folder,String solutionJavaName, String resultId, String topicId, String commitContent) {
        //提交次数+1
        commitlock.lock();
        try {
            Topic topic = topicDao.findById(topicId);
            Update topicUpdate = new Update();
            topicUpdate.set("commitCount", topic.getCommitCount()+1);
            topicDao.updateById(topicId,topicUpdate);
        } catch (Exception e) {
            log.error("更新题目提交次数失败，topicId-{}", topicId, e);
        } finally {
            commitlock.unlock();
        }

        Update updateSet = null;
        File solutionJava = null;
        boolean resultAc = false;
        //创建java文件
        try {
            solutionJava = this.createSolutionJava(folder, solutionJavaName, commitContent);
        } catch (Exception e) {
            updateSet = new Update();
            updateSet.set("status", ResultStatusEnum.COMPILE_FAIL.code)
                     .set("executionResult", e.getMessage())
                     .set("updateTime", new Date());
            resultDao.updateById(resultId, updateSet);

            this.release(solutionJava);
            return;
        }
        //编译文件
        try {
            Thread.sleep(1000L);
            this.compileSolutionJava(solutionJava);
        } catch (Exception e) {
            updateSet = new Update();
            updateSet.set("status", ResultStatusEnum.COMPILE_FAIL.code)
                    .set("executionResult", e.getMessage())
                    .set("updateTime", new Date());
            resultDao.updateById(resultId, updateSet);

            this.release(solutionJava);
            return;
        }
        //执行并验证结果
        try {
            Thread.sleep(2000L);
            String result = this.executeDataValidation(folder, solutionJavaName, topicId);
            updateSet = new Update();
            if(result != null) {
                updateSet.set("status", ResultStatusEnum.RESULT_ERROR.code)
                        .set("executionResult", result)
                        .set("updateTime", new Date());
            } else {
                updateSet.set("status", ResultStatusEnum.AC.code)
                        .set("executionResult", "运行通过")
                        .set("updateTime", new Date());
                resultAc = true;
            }
            resultDao.updateById(resultId, updateSet);

            //更新问题通过次数
            if(resultAc) {
                aclock.lock();
                try {
                    Topic topic = topicDao.findById(topicId);
                    Update topicUpdate = new Update();
                    topicUpdate.set("acCount", topic.getAcCount()+1);
                    topicDao.updateById(topicId,topicUpdate);
                } catch (Exception e) {
                    log.error("更新题目通过次数失败，topicId-{}", topicId, e);
                } finally {
                    aclock.unlock();
                }
            }
        } catch (Exception e) {
            updateSet = new Update();
            updateSet.set("status", ResultStatusEnum.RUNTIME_EXCEPTION.code)
                    .set("executionResult", e.getMessage())
                    .set("updateTime", new Date());
            resultDao.updateById(resultId, updateSet);
        }

        this.release(solutionJava);
    }

    /**
     * 根据提交的内容，生成待编译的JAVA文件
     */
    private File createSolutionJava(File folder, String solutionJavaName,String commitContent) throws Exception {
        File solutionJava = new File(folder, solutionJavaName+JAVA_SUFFIX);
        try {
            Files.write(solutionJava.toPath(), (SOLUTION_CLASS + solutionJavaName + "{"+ commitContent + "}").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new Exception("写入待编译文件失败，请联系管理员");
        }
        return solutionJava;
    }

    /**
     * 编译文件
     */
    private void compileSolutionJava(File solutionJava) throws Exception{
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new Exception("系统繁忙，请联系管理员");
        }

        int compilationResult = compiler.run(null, null, null,"-nowarn", solutionJava.getPath());
        if (compilationResult != 0) {
            throw new Exception("编译失败");
        }
    }

    /**
     * 执行数据验证
     * @return 抛异常或者非null输出均视为失败
     */
    private String executeDataValidation(File folder, String solutionJavaName, String topicId) throws Exception{
        try {
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {folder.toURI().toURL()});
            Class  cls = Class.forName(solutionJavaName, true, classLoader);
            Object instance = cls.newInstance();
            Method method = cls.getDeclaredMethod(SOLUTION_METHOD, String.class);

            List<TopicDataValidation> validations = topicDataValidationDao.findAll(new Query(Criteria.where("topicId").is(topicId)));
            if(validations == null || validations.size() == 0) {
                throw new Exception("无法获取验证数据，请联系管理员");
            }
            String result = null;
            for(TopicDataValidation validation : validations) {
                result = (String) method.invoke(instance, validation.getInput());
                if(!validation.getOutput().equals(result)) {
                    StringBuilder resultBuilder = new StringBuilder();
                    resultBuilder.append("结果不匹配！")
                            .append("输入：").append(validation.getInput())
                            .append("，正确输出：").append(validation.getOutput())
                            .append("，运行输出：").append(result);
                    return resultBuilder.toString();
                }
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    private void release(File solutionJava) {
        int index = solutionJava.getPath().indexOf(".java");
        if( index > 0) {
            String solutionClassPath = solutionJava.getPath().substring(0, index) + CLASS_SUFFIX;
            File solutionClass = new File(solutionClassPath);
            if(solutionClass.exists()) {
                solutionClass.delete();
            }
        }
        if(solutionJava.exists()) {
            solutionJava.delete();
        }

    }
}
