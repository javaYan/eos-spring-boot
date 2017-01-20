package eos.java.practice.reflection.entity;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by yanyuyu on 2017/1/19.
 */
public class TestReflect {

    @Test
    public void testFiled() {
        Ref ref = new Ref();
        ref.setId("666");
        ref.setName("wang er");

        try {
            Object obj = ref;
            Field id = Ref.class.getDeclaredField("id");
            id.setAccessible(true);
            Object o = id.get(obj);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
