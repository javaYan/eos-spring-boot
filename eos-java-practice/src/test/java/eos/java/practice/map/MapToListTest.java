package eos.java.practice.map;

import eos.java.practice.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yanyuyu on 2017/2/21.
 */
public class MapToListTest {
    @Test
    public void testMapToList() {
        long startTime = System.nanoTime();

        ConcurrentHashMap<Long,Student> map = new ConcurrentHashMap<Long,Student>();
        for(int i = 0; i < 3000; i ++) {
            Student stu = new Student();
            stu.setId(i);
            stu.setName("学生"+ String.format("%4d", i));
            map.put(Long.valueOf(i), stu);
        }
        ArrayList<Student> list = new ArrayList<Student>(map.values());

        long endTime = System.nanoTime();
        System.out.println("cost " + (endTime-startTime)/1000 + " ms, deal size " + list.size());

    }

    @Test
    public void testList() {
        long startTime = System.nanoTime();

        Vector<Student> vector = new Vector<Student>();
        for(int i = 0; i < 3000; i ++) {
            Student stu = new Student();
            stu.setId(i);
            stu.setName("学生"+ String.format("%4d", i));
            vector.add(stu);
        }

        long endTime = System.nanoTime();
        System.out.println("cost " + (endTime-startTime)/1000 + " ms, deal size " + vector.size());
    }
}
