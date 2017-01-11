package eos.java.practice.crossdomain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/11.
 */
@Controller
public class NoCrossController {

    @RequestMapping(value="noCross",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> doGet() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result","no_cross_result");
        return map;
    }
}
