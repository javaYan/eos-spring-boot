package eos.java.practice.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by yanyuyu on 2017/1/12.
 */
public class SingleThreadExecutor_ {

    public static void main(String args[]) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---------------"+Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("+++++++++++++++"+Thread.currentThread().getName());
                } catch (Exception e) {

                }
            }
        };
        Executor executor = Executors.newSingleThreadExecutor();//单线程方式执行
        for(int i = 0; i < 10; i ++) {
            executor.execute(runnable);
        }

    }
}
