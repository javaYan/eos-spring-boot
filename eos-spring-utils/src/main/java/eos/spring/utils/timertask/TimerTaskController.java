package eos.spring.utils.timertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/4.
 */
@RestController("timerTask")
public class TimerTaskController {

    @Autowired
    private TimerTaskContainer timerTaskContainer;

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> doPut(Integer id) {
        timerTaskContainer.updateTimer(id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("size", timerTaskContainer.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> doPost(Integer id) {
        timerTaskContainer.addTimer(id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("size", timerTaskContainer.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> doDelete(Integer id) {
        timerTaskContainer.removeTimer(id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("size", timerTaskContainer.size());
        return map;
    }
}
