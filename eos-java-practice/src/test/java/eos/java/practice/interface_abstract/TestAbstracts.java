package eos.java.practice.interface_abstract;

import eos.java.practice.interface_abstract.abstracts.SubB;
import eos.java.practice.interface_abstract.interfaces.SubA;
import eos.java.practice.interface_abstract.interfaces.SubA1;
import org.junit.Test;

/**
 * Created by yanyuyu on 2017/3/17.
 */
public class TestAbstracts {

    @Test
    public void testSubA() {
        SubB subB = new SubB();
        subB.printId(); //2
    }

}
