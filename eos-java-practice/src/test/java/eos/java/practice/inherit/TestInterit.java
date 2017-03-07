package eos.java.practice.inherit;

import org.junit.Test;

/**
 * Created by yanyuyu on 2017/3/7.
 */
public class TestInterit {
    @Test
    public void test() {
        Son son = new Son();
        son.setId(3);
        son.setName("son");
        GrandFather grandFather = (GrandFather) son;
        System.out.println(son);
        System.out.println(grandFather);
        System.out.println(grandFather.getId());
        System.out.println(grandFather.getName());

        GrandFather grandFather1 = new GrandFather();
        grandFather1.setId(1);
        grandFather1.setName("GrandFather");
        System.out.println(grandFather1);

    }
}
