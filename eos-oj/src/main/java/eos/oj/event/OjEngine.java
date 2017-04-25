package eos.oj.event;

import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDataValidationDao;
import eos.oj.entity.TopicDataValidation;
import eos.oj.enums.ResultStatusEnum;
import eos.oj.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr_yyy on 2017/4/24.
 */
@Slf4j
@Service
public class OjEngine {

    private static final String JAVA_SUFFIX = ".java";

    @Autowired
    private TopicDataValidationDao topicDataValidationDao;

    @Autowired
    private ResultDao resultDao;

    public void fire(String absoluteFileDir,String fileName, String resultId, String topicId, String commitContent) {
        Update update = null;
        try {
            this.newOJ(absoluteFileDir,fileName,topicId,commitContent);
            Thread.sleep(3000L);
            this.compileOjFile(absoluteFileDir + "/" + fileName + ".java");
            update = new Update();
            update.set("status", ResultStatusEnum.RUNNING.code).set("updateTime", new Date());
            resultDao.updateById(resultId, update);
        } catch (Exception e) {
            String message = e.getMessage();
            if(message.length() > 10000) {
                message = message.substring(0, 10000);
            }
            update = new Update();
            update.set("status", ResultStatusEnum.COMPILE_FAIL.code).set("executionResult", message).set("updateTime", new Date());
            resultDao.updateById(resultId, update);
            return ;
        }
        try {
            Thread.sleep(3000L);
            this.execute(absoluteFileDir, fileName);

            update = new Update();
            update.set("status",ResultStatusEnum.AC.code).set("updateTime", new Date());
            resultDao.updateById(resultId, update);
        } catch (Exception e) {
            String message = e.getMessage();
            if(message.length() > 10000) {
                message = message.substring(0, 10000);
            }
            update = new Update();
            update.set("status", message.contains("result is not correct") ? ResultStatusEnum.RESULT_ERROR.code : ResultStatusEnum.RUNTIME_EXCEPTION.code).set("executionResult", message);
            resultDao.updateById(resultId, update);
            return ;
        }


    }

    /**
     * 根据问题ID和提交的内容，动态加载代码并生成JAVA文件
     */
    public void newOJ(String absoluteFileDir,String fileName, String topicId, String commitContent) throws Exception {
        File ojFile = this.createOjFile(absoluteFileDir, fileName);
        if(ojFile == null) {
            throw new Exception("引擎生成临时文件出错，请联系管理员");
        }
        List<TopicDataValidation> validations = topicDataValidationDao.findAll(new Query(Criteria.where("topicId").is(topicId)));
        if(CollectionUtils.isEmpty(validations)) {
            throw new Exception("缺少测试数据，请联系管理员");
        }
        StringBuilder mainBuilder = new StringBuilder("\t\tString result = null;\n");
        for(TopicDataValidation validation : validations) {
            mainBuilder.append("\t\tif( !(result = solution(\"").append(validation.getInput()).append("\")).equals(\"").append(validation.getOutput()).append("\") ) {\n")
                       .append("\t\t\tthrow new Exception(\"result is not correct for {").append(validation.getInput()).append("},result is: ").append(validation.getOutput()).append(", but yours is:\" + result);\n")
                       .append("\t\t}\n");
        }
        StringBuilder codesBuilder = new StringBuilder("\n")
                .append("import java.util.*;\n")
                .append("public class ").append(fileName).append(" {\n")
                .append("\tpublic static String solution(String line) {\n")
                .append(commitContent).append("\n")
                .append("\t}\n")
                .append("\tpublic static void main(String []args) throws Exception {\n")
                .append(mainBuilder.toString()).append("\n")
                .append("\t}\n")
                .append("}");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(ojFile.getPath());
            outputStream.write(codesBuilder.toString().getBytes());
        } catch (Exception e) {
            log.error("系统异常",e);
            throw new Exception("系统异常！" );
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                log.error("关闭文件流异常", e);
            }
        }

    }

    /**
     * 编译OJ文件
     * D:\Temp下的Hello.java中含有main方法
     * javac D:\Temp\Hello.java  生成Hello.class
     * java -classpath D:\Temp Hello        运行程序
     * @param absoluteFilePath
     * @return
     */
    public void compileOjFile(String absoluteFilePath) throws Exception {
        BufferedReader reader = null;
        try {
            String commandStr = "javac " + absoluteFilePath;
            Process p = Runtime.getRuntime().exec(commandStr);
            reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line.trim() + "\n");
            }
            if(StringUtil.isNotEmpty(sb.toString())) {
                throw new Exception(sb.toString());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 执行并获取结果
     */
    public void execute(String absoluteFilePath, String fileName) throws Exception {
        if(absoluteFilePath.indexOf(".java") > 0) {
            absoluteFilePath = absoluteFilePath.substring(0,absoluteFilePath.indexOf(".java"));
        }
        BufferedReader br = null;
        Process process = null;
        try {
            long startTime = System.currentTimeMillis();
            String commandStr = "java -classpath " + absoluteFilePath + " " + fileName;
            process = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            try {
                process.exitValue();
            } catch (IllegalThreadStateException e) {

            }
            if (StringUtil.isNotEmpty(sb.toString())) {
                throw new Exception(sb.toString());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成OJ文件
     * @param dirPath
     * @param fileName
     */
    private File createOjFile(String dirPath,String fileName) {
        try {
            File f = new File(dirPath+"/"+fileName+JAVA_SUFFIX);
            if(f.exists()) {
                f.delete();
            }
            f.createNewFile();
            return f;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
