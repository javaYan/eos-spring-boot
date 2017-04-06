package eos.thymeleaf.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/4/6.
 */
@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {
    @RequestMapping(value="view" , method= RequestMethod.GET)
    public ModelAndView view(@RequestParam("name") String name) {
        log.info("student params:{}", name);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "student:"+name);
        return new ModelAndView("student/student", map);
    }
}