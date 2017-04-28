package eos.oj.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import eos.oj.event.common.EventListener;
import eos.oj.util.StringUtil;
import eos.oj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@Slf4j
@Component
public class OjListener implements EventListener{

    private static final String SOLUTION_FILE_PREFIX = "Solution";
    private static final String TEMP_PATH_DEFAULT = "D:/temp";
    private static final String TEMP_PATH;
    private static final File folder;
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
            folder = new File(TEMP_PATH);
            if(!folder.exists()) {
                folder.mkdir();
            }
            try {
                in.close();
            } catch (IOException e) {
                log.error("关闭输入流错误", e);
            }
        }
    }

    @Subscribe
    @AllowConcurrentEvents
    public void onPostResultEvent(PostResultEvent event) {
        System.out.println("run haha" + Thread.currentThread().getName());
        String id = event.getId();
        ResultVo data = event.getData();
        log.info("listener receive PostResultEvent : id-[{}], data-[{}]", id, data);
        if(!StringUtil.isNotEmpty() || data == null) {
            log.error("PostResultEvent error : param can't be empty or null! ");
            return ;
        }

        String commitContent = data.getCommitContent();
        String solutionJavaName = SOLUTION_FILE_PREFIX + System.nanoTime();
        try {
            ojEngine.run(folder, solutionJavaName, data.getId(), data.getTopicId(), commitContent);
        } catch (Exception e) {
            //忽略异常
        }
    }

}
