package stream;

import common.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Title: testFor
 * Author: yanyuyu
 * Date: 2017-09-24 14:39
 */

public class testFor {
    
    private List<Student> studentList;
    
    @Before
    public void before() {
        studentList = new ArrayList<Student>();
        Student stu;
        for(int i = 0; i < 20; i ++) {
            stu = new Student();
            stu.setId((long) i);
            stu.setName("学生"+i);
            stu.setNumber("number"+i);
            stu.setSex(new Random().nextInt(2));

            studentList.add(stu);
        }
    }
    
    @After
    public void after() {
        
    }
    
    @Test
    public void testGetFirst() {
        for(Student stu : studentList) {
            if("学生8".equals(stu.getName())) {
                System.out.println(stu);
                return;
            }
        }
    }
    
    @Test
    public void testGetFirstFor8_01() {
        Optional<Student> first = studentList.stream().filter(student -> "学生8".equals(student.getName()))
                .findFirst();
        if(first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("没有找到");
        }
    }
    
    @Test
    public void testGetFirstFor8_02() {
        //foreach会全部扫描一遍
        studentList.forEach(student -> {
            System.out.println("---"+student);
            if("学生8".equals(student.getName())) {
                System.out.println(student);
                return; //此处return并非是停止循环，而类似continue
            }
            System.out.println("没有找到");
        });
    }
    
    
    //////////////////
    
    @Test
    public void testGetSome() {
        List<Student> subList = new ArrayList<Student>();
        for(Student stu : studentList) {
            if(stu.getId() % 2 == 0) {
                subList.add(stu);
            }
        }

        for(Student stu : subList) {
            System.out.println(stu);
        }
    }

    @Test
    public void testGetSomeFor8_01() {
        List<Student> subList = studentList.stream().filter(
                student -> student.getId() % 2 == 0 
        ).collect(Collectors.toList());
        
        subList.forEach(System.out::println);
    }

    @Test
    public void testGetSomeFor8_02() {
        List<Student> subList = new ArrayList<Student>();
        studentList.forEach(student -> {
            if(student.getId()%2 == 0 ) {
                subList.add(student);
            }
        });
        subList.forEach(System.out::println);

        
    }
}
