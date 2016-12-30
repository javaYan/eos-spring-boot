package eos.guava.eventbus.event;

import com.google.common.eventbus.Subscribe;
import eos.guava.eventbus.common.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@Component
public class MyListener implements EventListener{

    @Subscribe
    public void onLongEvent(LongEvent event) {
        System.out.println("listener receive longEvent :" + event);
    }

    @Subscribe
    public void onMapEvent(MapEvent event) {
        System.out.println("listener receive mapEvent :" + event);
    }
}
