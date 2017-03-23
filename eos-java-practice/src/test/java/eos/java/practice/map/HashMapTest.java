package eos.java.practice.map;

import eos.java.practice.entity.Student;
import eos.java.practice.map.auxiliary.HashMapThread;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/4.
 */
public class HashMapTest {
    @Test
    public void testGetString() {
        Map<Integer,String> map = new java.util.HashMap<Integer,String>();
        for(int i = 0; i < 10 ; i ++) {
            map.put(i, "Value_" + i);
        }
        System.out.println(map);

        String value = map.get(5);
        value = "123";
        System.out.println(map);
    }

    @Test
    public void testGetObject() {
        Map<Integer,Student> map = new java.util.HashMap<Integer,Student>();
        for(int i = 0; i < 10 ; i ++) {
            Student student = new Student(i, "student_"+i);
            map.put(i, student);
        }
        System.out.println(map);

        Student stu = map.get(5);
        stu.setName("new name");
        stu.setId(555);
        System.out.println(map);
    }

    /**
     * 测试多线程下hashMap的非线程安全
     */
    @Test
    public void testMultiThread() {

        try {
            HashMapThread mapThread1 = new HashMapThread();
            HashMapThread mapThread2 = new HashMapThread();

            Thread thread1 = new Thread(mapThread1);
            Thread thread2 = new Thread(mapThread2);

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            //下述这种方式不是多线程  是thread1执行完成继续下述的thread2
            /*thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();*/
        } catch (Exception e) {

        }

        System.out.println(HashMapThread.map.size());
        //结果可能会大于1000000 说明hashMap的结构可能被破坏了 没有key的唯一性可言
    }

    @Test
    public void testCapacity() {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < 20; i ++) {
            map.put(i,i);
            if(i==15) {
                System.out.print("15");
            }
        }

    }
}
