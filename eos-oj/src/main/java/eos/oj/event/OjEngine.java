package eos.oj.event;

import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDataValidationDao;
import eos.oj.entity.TopicDataValidation;
import eos.oj.enums.ResultStatusEnum;
import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void fire(String absoluteFilePath,String fileName, String resultId, String topicId, String commitContent) {
        try {
            this.newOJ(absoluteFilePath,fileName,topicId,commitContent);
            this.compileOjFile(absoluteFilePath);
        } catch (Exception e) {
            Update update = new Update();
            String message = e.getMessage();
            if(message.length() > 10000) {
                message = message.substring(0, 10000);
            }
            update.set("status", ResultStatusEnum.COMPILE_FAIL.code).set("executionResult", message);
            resultDao.updateById(resultId, update);
        }
        try {
            this.execute(absoluteFilePath);
        } catch (Exception e) {
            Update update = new Update();
            String message = e.getMessage();
            if(message.length() > 10000) {
                message = message.substring(0, 10000);
            }
            update.set("status", message.startsWith("result is not correct") ? ResultStatusEnum.RUNTIME_EXCEPTION : ResultStatusEnum.RESULT_ERROR).set("executionResult", message);
            resultDao.updateById(resultId, update);
        }


    }

    /**
     * 根据问题ID和提交的内容，动态加载代码并生成JAVA文件
     */
    public void newOJ(String absoluteFilePath,String fileName, String topicId, String commitContent) {
        File ojFile = this.createOjFile(absoluteFilePath, fileName);
        if(ojFile == null) {
            throw new BaseException(RestCodeMessage.Code.INTERNAL_SERVER_ERROR, "引擎生成临时文件出错，请联系管理员");
        }
        List<TopicDataValidation> validations = topicDataValidationDao.findAll(new Query(Criteria.where("topicId").is(topicId)));
        if(CollectionUtils.isEmpty(validations)) {
            throw new BaseException(RestCodeMessage.Code.INTERNAL_SERVER_ERROR, "缺少测试数据，请联系管理员");
        }
        StringBuilder mainBuilder = new StringBuilder("\t\tString result = null;");
        for(TopicDataValidation validation : validations) {
            // String result = null;
            // if( !(result = this.solution(validation.getInput())).equals(validation.getOutput()) ) {
            //      throw new Exception("result is not correct for \""+validation.getInput()+"\", result is \"" +validation.getOutput()+ "\", but yours is \""+result+"\"");
            // }
            mainBuilder.append("\t\tif( !(result = this.solution(").append(validation.getInput()).append(")).equals(").append(validation.getOutput()).append(") ) {")
                       .append("\t\t\tthrow new Exception(\"result is not correct for \"").append(validation.getInput()).append("\",result is \"").append(validation.getOutput()).append("\", but yours is \"result\"")
                       .append("\t\t}");
        }
        StringBuilder codesBuilder = new StringBuilder("\n")
                .append("import java.util.*;")
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
            throw new BaseException(RestCodeMessage.Code.INTERNAL_SERVER_ERROR, RestCodeMessage.Message.INTERNAL_SERVER_ERROR);
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
     * java D:\Temp Hello        运行程序
     * @param absoluteFilePath
     * @return
     */
    public void compileOjFile(String absoluteFilePath) {

    }

    /**
     * 执行
     */
    public void execute(String absoluteFilePath) {

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
