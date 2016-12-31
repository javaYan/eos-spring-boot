package eos.guava.eventbus.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import eos.guava.eventbus.common.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@Component
public class MyListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Subscribe
    public void onDeleteEvent(DeleteEvent event) {
        logger.info("listener receive longEvent -" + event);
    }

    @Subscribe
    public void onPutEvent(PutEvent event) {
        logger.info("listener receive mapEvent -" + event);
    }

    @Subscribe
    public void onPostEvent(PostEvent event) {
        logger.info("listener receive myEvent : id-[{}], data-[{}]", event.getId(), event.getData());
    }

    @Subscribe
    public void onMyEvent(DeadEvent event) {
        logger.info("listener receive uncaught event -" + event);
    }
}
