package eos.oj.event;

import com.google.common.eventbus.Subscribe;
import eos.oj.event.common.EventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@Slf4j
@Component
public class OjListener implements EventListener{


    @Subscribe
    public void onPostResultEvent(PostResultEvent event) {
        log.info("listener receive myEvent : id-[{}], data-[{}]", event.getId(), event.getData());
    }

}
