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

    @Subscribe
    public void onPostResultEvent(PostResultEvent event) {
        String id = event.getId();
        ResultVo data = event.getData();
        log.info("listener receive myEvent : id-[{}], data-[{}]", id, data);
        if(!StringUtil.isNotEmpty() || data == null) {
            log.error("PostResultEvent error : param can't be empty or null! ");
            return ;
        }

        // D:\Temp下的Hello.java中含有main方法
        // javac D:\Temp\Hello.java  生成Hello.class
        // java D:\Temp Hello    运行程序


        long nanoTime = System.nanoTime();
        String commitContent = data.getCommitContent();


    }

    private void createCommitContentJavaFile() {
        FileOutputStream outputStream = null;
        try {
            long nanoTime = System.nanoTime();
            StringBuffer sb = new StringBuffer("\n");
            String fileName = "OjResult" + nanoTime;
            sb.append("public class ").append(fileName).append(" {\n")
                    .append("\tpublic static void main(String args[]) {\n")
                    .append("\t\tSystem.out.println(12345678);\n")
                    .append("\t}\n")
                    .append("}\n");
            File f = new File("E:/temp/"+fileName+".java");
            if(f.exists()) {
                f.delete();
            }
            f.createNewFile();
            outputStream = new FileOutputStream(f.getPath());
            outputStream.write(sb.toString().getBytes());
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
