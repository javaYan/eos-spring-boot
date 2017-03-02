package eos.spring.utils.aop;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by yanyuyu on 2017/2/28.
 */

@Service("demoAopService")
public class DemoAopService {
    public void init(DemoDto demoDto) {
        System.out.println("DemoAopService init execute !");
    }

    public void work(String workId, Date workTime) { System.out.println("DemoAopService work execute !"); }

    public void ex() {
        int num = 1/0;
    }

}
