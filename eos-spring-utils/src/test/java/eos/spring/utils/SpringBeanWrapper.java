package eos.spring.utils;

import eos.spring.utils.entity.Course;
import eos.spring.utils.entity.StudentVo;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanyuyu on 2017/1/4.
 */
public class SpringBeanWrapper {
    @Test
    public void testPropertyValue() {
        StudentVo vo = new StudentVo();
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(vo);
        beanWrapper.setPropertyValue("name","Jack");
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course());
        courses.add(new Course());
        beanWrapper.setPropertyValue("courses", courses);
        System.out.println(vo);
        beanWrapper.setPropertyValue("courses[0].id",111L);
        beanWrapper.setPropertyValue("courses[0].name","name1");
        beanWrapper.setPropertyValue("courses[1].id",222L);
        beanWrapper.setPropertyValue("courses[1].name","name2");
        System.out.println(vo);
    }

}
