package eos.spring.utils;

import eos.spring.utils.entity.StudentEntity;
import eos.spring.utils.entity.StudentVo;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by yanyuyu on 2017/1/4.
 */
public class SpringBeanUtils {
    /**
     * 复制属性值给新对象
     */
    @Test
    public void testCopyProperties() {
        StudentEntity entity = new StudentEntity();
        entity.setId(1L);
        entity.setName("Mr_yyy");
        entity.setAddress("地址1");
        entity.setAge(18);
        entity.setBirthDay(new Date());
        entity.setRoleId(1);

        StudentVo vo = new StudentVo();
        BeanUtils.copyProperties(entity, vo);
        System.out.println(vo);
    }

    /**
     * 实例化一个类
     */
    @Test
    public void testInstantiateClass() {
        StudentEntity entity = new StudentEntity();
        entity.setId(1L);
        entity.setName("Mr_yyy");
        entity.setAddress("地址1");
        entity.setAge(18);
        entity.setBirthDay(new Date());
        entity.setRoleId(1);

        StudentVo vo = BeanUtils.instantiateClass(StudentVo.class);
        BeanUtils.copyProperties(entity, vo);
        System.out.println(vo);
    }
}
