package eos.guava.eventbus.controller;

import eos.guava.eventbus.common.EventDispatcher;
import eos.guava.eventbus.event.DeleteEvent;
import eos.guava.eventbus.event.PutEvent;
import eos.guava.eventbus.event.PostEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@RestController("send")
public class SendController {

    private static Logger logger =  LoggerFactory.getLogger(SendController.class);

    @Autowired
    private EventDispatcher eventDispatcher;

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(@RequestParam(name = "id") String id) {
        logger.info("Get : " + id);
        Object object = new Object();
        eventDispatcher.publish(object);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(@RequestParam(name = "id") String id) {

        logger.info("Post : " + id);

        PostEvent myEvent = new PostEvent("66");
        myEvent.setData("ss");
        eventDispatcher.publish(myEvent);

        PostEvent myEvent2 = new PostEvent("77");
        eventDispatcher.publish(myEvent2);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void doPut(@RequestParam(name = "id") String id) {
        logger.info("Put : " + id);
        Map<String, Object> mapData = new HashMap<String, Object>();
        mapData.put("number", 9527L);
        mapData.put("address", "SDTZ");
        PutEvent mapEvent = new PutEvent(mapData);
        eventDispatcher.publish(mapEvent);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void doDelete(@RequestParam(name = "id") String id) {
        logger.info("Delete : " + id);
        DeleteEvent event = new DeleteEvent(9527L);
        eventDispatcher.publish(event);
    }
}
