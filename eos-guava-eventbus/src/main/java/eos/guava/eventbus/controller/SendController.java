package eos.guava.eventbus.controller;

import eos.guava.eventbus.common.EventDispatcher;
import eos.guava.eventbus.event.LongEvent;
import eos.guava.eventbus.event.MapEvent;
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

    @Autowired
    private EventDispatcher eventDispatcher;

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(@RequestParam(name = "id") String id) {
        System.out.println("Get ok : " + id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(@RequestParam(name = "id") String id) {

        System.out.println("Post ok : " + id);
        LongEvent event = new LongEvent(9527L);
        eventDispatcher.publish(event);

        Map<String, Object> mapData = new HashMap<String, Object>();
        mapData.put("number", 9527L);
        mapData.put("address", "SDTZ");
        MapEvent mapEvent = new MapEvent(mapData);
        eventDispatcher.publish(mapEvent);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void doPut(@RequestParam(name = "id") String id) {
        System.out.println("Put ok : " + id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void doDelete(@RequestParam(name = "id") String id) {
        System.out.println("Delete ok : " + id);
    }
}
