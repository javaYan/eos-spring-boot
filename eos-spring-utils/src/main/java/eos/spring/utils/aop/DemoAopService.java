package eos.spring.utils.aop;

import org.springframework.stereotype.Service;

/**
 * Created by yanyuyu on 2017/2/28.
 */

@Service("demoAopService")
public class DemoAopService {
    public void doSomething() {
        System.out.println("DemoAopService doSomething execute !");
    }
}
