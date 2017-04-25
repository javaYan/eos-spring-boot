package eos.oj.event;

import com.google.common.eventbus.Subscribe;
import eos.oj.event.common.EventListener;
import eos.oj.util.StringUtil;
import eos.oj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@Slf4j
@Component
public class OjListener implements EventListener{

    private static final String OJ_FILE_PREFIX = "Oj";
    private static final String TEMP_PATH_DEFAULT = "D:/temp";
    private static final String TEMP_PATH;

    @Autowired
    private OjEngine ojEngine;

    static { // 初始化临时目录
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = OjListener.class.getResourceAsStream("/application.properties");
            properties.load(in);
        } catch (IOException e) {
            log.error("读取配置文件错误", e);
        } finally {
            TEMP_PATH = properties.getProperty("temp.file.path", TEMP_PATH_DEFAULT);
            File tempPath = new File(TEMP_PATH);
            if(!tempPath.exists()) {
                tempPath.mkdir();
            }
            try {
                in.close();
            } catch (IOException e) {
                log.error("关闭输入流错误", e);
            }
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


        long nanoTime = System.nanoTime();
        String commitContent = data.getCommitContent();
        String fileName = OJ_FILE_PREFIX + nanoTime;
        try {
            ojEngine.fire(TEMP_PATH, fileName, id, data.getTopicId(), commitContent);
        } catch (Exception e) {
            //忽略异常
        }
    }

}
