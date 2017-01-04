package eos.spring.utils.timertask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 构建一个定时器容器，可以及时的删除定时任务或者添加定时任务
 * Created by yanyuyu on 2017/1/4.
 */
@Slf4j
@Component
public class TimerTaskContainer implements InitializingBean {

    private static Map<Integer,Timer> timerTaskMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("------start init------");
        initTimerTaskMap();
        for(int i=0; i<10; i++) {
            final Integer id = new Integer(i);
            addTimer(id);
            Thread.sleep(400L);
        }
    }

    private void initTimerTaskMap () {
        if(timerTaskMap == null) {
            timerTaskMap = new HashMap<Integer,Timer>();
        }
    }

    public void addTimer(final Integer id) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                log.info("ID-{}已经执行", id);
            }
        };
        Timer timer = new Timer();
        Date date = new Date();
        Date timingDate = new Date(date.getTime() + 20000); //20s之后执行
        timer.schedule(task, timingDate);
        timerTaskMap.put(id, timer);
        log.info("{} 已经添加到定时器" , id);
    }

    public void updateTimer(final Integer id) {
        removeTimer(id);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                log.info("ID修改-{}已经执行", id);
            }
        };
        Timer timer = new Timer();
        Date date = new Date();
        Date timingDate = new Date(date.getTime() + 25000); //20s之后执行
        timer.schedule(task, timingDate);
        timerTaskMap.put(id, timer);
        log.info("{} 已经更新到定时器" , id);
    }

    public void removeTimer(final Integer id) {
        Timer removeTimer = timerTaskMap.remove(id);
        if(removeTimer != null) {
            log.info("{} 已经从定时器移除",id );
            removeTimer.cancel();
            removeTimer = null;
        } else {
            log.info("{} 不存在于当前定时器",id);
        }
    }

    public int size() {
        return timerTaskMap == null ? 0 : timerTaskMap.size();
    }
}
