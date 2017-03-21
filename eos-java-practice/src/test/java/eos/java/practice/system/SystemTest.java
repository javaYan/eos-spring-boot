package eos.java.practice.system;

import org.junit.Test;

/**
 * Created by Mr_yyy on 2017/3/21.
 */
public class SystemTest {
    /**
     * 获取当前系统核心线程数
     */
    @Test
    public void testAvailableProcessors() {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("当前系统CPU是 " + core + " 线程");
    }

    @Test
    public void testFreeMemory() {
        long freeMemory = Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("JVM可以从操作系统占用的最大内存是 " + maxMemory/1024/1024 +"MB");
        System.out.println("JVM已经从操作系统占用的内存是 " + totalMemory/1024/1024 +"MB");
        System.out.println("JVM中空闲的内存是 " + freeMemory/1024/1024 +"MB");
    }
}
