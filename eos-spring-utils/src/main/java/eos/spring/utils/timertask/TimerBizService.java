package eos.spring.utils.timertask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by yanyuyu on 2017/1/5.
 */
@Slf4j
@Component("timerBizService")
public class TimerBizService {
    public void executeByBatch(Integer id) {
        log.info("executeByBatch start for {}..." , id);
    }
}
