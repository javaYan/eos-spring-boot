package eos.springboot.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@SpringBootApplication
public class DBApplication {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        SpringApplication.run(DBApplication.class, args);
        long endTime = System.currentTimeMillis();
        long Time = endTime - starTime;
        System.out.println("\n启动时间:" + Time / 1000 + "秒");
        System.out.println("...............................................................");
        System.out.println("..................Service starts successfully..................");
        System.out.println("...............................................................");
    }
}
