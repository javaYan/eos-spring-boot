package eos.thymeleaf.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/4/5.
 */
@Slf4j
@Controller
@RequestMapping("hello")
public class HelloController {
    @RequestMapping(value="gethello" , method=RequestMethod.GET)
    public ModelAndView gethello(@RequestParam("name") String name) {
        log.info("gethello params:{}", name);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title", "hello:"+name);
        return new ModelAndView("hello", map);
    }
}
