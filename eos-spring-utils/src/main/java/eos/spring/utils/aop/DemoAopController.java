package eos.spring.utils.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by yanyuyu on 2017/3/1.
 */
@RestController()
@RequestMapping("demoAop")
public class DemoAopController {
    @Autowired
    private DemoAopService demoAopService;

    @RequestMapping(value="init",method= RequestMethod.GET)
    public void init() {
        DemoDto dto = new DemoDto("num_9527","xiaoli",18);
        demoAopService.init(dto);
    }

    @RequestMapping(value="work",method= RequestMethod.GET)
    public void work() {
        demoAopService.work("work_1",new Date());
    }

    @RequestMapping(value="ex",method= RequestMethod.GET)
    public void ex() {
        demoAopService.ex();
    }
}
