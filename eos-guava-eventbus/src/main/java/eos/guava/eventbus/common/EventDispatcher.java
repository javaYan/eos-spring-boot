package eos.guava.eventbus.common;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@Component
public class EventDispatcher {

    protected final EventBus eventBus;

    public EventDispatcher() {
        this(Runtime.getRuntime().availableProcessors()+1);
    }

    public EventDispatcher(Integer threadCount) {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadCount));
    }

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void registerListeners() {
        Map<String, EventListener> eventListeners = applicationContext.getBeansOfType(EventListener.class);
        for(EventListener listener : eventListeners.values()) {
            System.out.println("EventBus register - " + listener.getClass().getName());
            eventBus.register(listener);
        }
    }

    public void publish(Object event) {
        eventBus.post(event);
    }
}
