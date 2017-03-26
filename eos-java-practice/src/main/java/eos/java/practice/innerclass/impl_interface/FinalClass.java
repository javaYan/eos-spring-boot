package eos.java.practice.innerclass.impl_interface;

/**
 * 当有方法重名的多个类或接口时，使用内部类可以解决具体指定调用哪个方法
 * 如Interface1有output  Class1有output 则可以继承Class1并且使用内部类实现Interface1
 * Created by Mr_yyy on 2017/3/25.
 */
public class FinalClass extends Class1{
    public void class1_output() {
        super.output();
    }

    private class I1 implements Interface1 {

        @Override
        public void output() {
            System.out.println("Interface1 output");
        }
    }

    public void interface1_output() {
        new I1().output();
    }


    public static void main(String [] args) {
        FinalClass fc = new FinalClass();
        fc.output();
        fc.class1_output();
        fc.interface1_output();
    }
}
