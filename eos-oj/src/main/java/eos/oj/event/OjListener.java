package eos.oj.event;

import com.google.common.eventbus.Subscribe;
import eos.oj.event.common.EventListener;
import eos.oj.util.StringUtil;
import eos.oj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@Slf4j
@Component
public class OjListener implements EventListener{

    private static final String COMMIT_JAVA_FILE_PREFIX = "OjTest";
    private static final String MAIN_JAVA_FILE_PREFIX = "OjMain";
    private static final String TEMP_PATH = "D:/temp";

    static { // 初始化临时目录文件
        File tempPath = new File(TEMP_PATH);
        if(!tempPath.exists()) {
            tempPath.mkdir();
        }
    }

    @Subscribe
    public void onPostResultEvent(PostResultEvent event) {
        String id = event.getId();
        ResultVo data = event.getData();
        log.info("listener receive PostResultEvent : id-[{}], data-[{}]", id, data);
        if(!StringUtil.isNotEmpty() || data == null) {
            log.error("PostResultEvent error : param can't be empty or null! ");
            return ;
        }

        // D:\Temp下的Hello.java中含有main方法
        // javac D:\Temp\Hello.java  生成Hello.class
        // java D:\Temp Hello    运行程序

        long nanoTime = System.nanoTime();
        String commitContent = data.getCommitContent();
        String mainContent = "String s = solution(\"1234\");";
        createCommitJavaFile(nanoTime,commitContent, mainContent);
    }

    /**
     * 创建提交的JAVA文件
     * @param nanoTime
     * @param commitContent
     */
    private void createCommitJavaFile(long nanoTime, String commitContent, String mainContent) {
        FileOutputStream outputStream = null;
        try {
            String fileName = COMMIT_JAVA_FILE_PREFIX + nanoTime;
            StringBuilder javaBuilder = new StringBuilder("\n")
                    .append("public class ").append(fileName).append(" {\n")
                    .append("\tpublic static String solution(String line) {\n")
                    .append(commitContent).append("\n")
                    .append("\t}\n")
                    .append("\tpublic static void main(String []args) {\n")
                    .append(mainContent).append("\n")
                    .append("\t}\n")
                    .append("}");

            File f = new File(TEMP_PATH+"/"+fileName+".java");
            if(f.exists()) {
                f.delete();
            }
            f.createNewFile();
            outputStream = new FileOutputStream(f.getPath());
            outputStream.write(javaBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
