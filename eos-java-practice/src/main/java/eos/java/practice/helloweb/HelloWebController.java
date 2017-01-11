package eos.java.practice.helloweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

/**
 * Created by yanyuyu on 2017/1/11.
 */
@Controller
public class HelloWebController {
    @RequestMapping(value="helloWeb", method=RequestMethod.GET)
    public String helloWeb(Model model) {
        Random random = new Random(System.currentTimeMillis());
        model.addAttribute("randomValue", random.nextLong());
        return "helloweb/hello-web";
    }
}
