import eos.java.practice.entity.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/4.
 */
public class Map_Get {
    @Test
    public void testGetString() {
        Map<Integer,String> map = new HashMap<Integer,String>();
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
        Map<Integer,Student> map = new HashMap<Integer,Student>();
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
}
