package eos.thymeleaf;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yanyuyu on 2017/4/5.
 */
@RestController("helloController")
@RequestMapping("hello")
public class HelloController {
    @GetMapping("{name}")
    public ModelAndView view(@PathVariable("name") String name) {
        return new ModelAndView("hello", "title", "hello:"+name);
    }
}
