package eos.java.practice.interface_abstract;

import eos.java.practice.interface_abstract.interfaces.SubA;
import eos.java.practice.interface_abstract.interfaces.SubA1;
import org.junit.Test;

/**
 * Created by yanyuyu on 2017/3/17.
 */
public class TestInterfaces {

    @Test
    public void testSubA() {
        SubA subA = new SubA();
        subA.printfId(); //0
    }

    @Test
    public void testSubA1() {
        SubA1 subA1 = new SubA1();
        subA1.printfId(); //1
    }
}
