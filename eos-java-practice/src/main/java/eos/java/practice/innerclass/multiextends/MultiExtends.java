package eos.java.practice.innerclass.multiextends;

/**
 * 使用内部类可以达到多重继承的效果
 * 使用内部类E1和内部类E2分别继承了Example1和Example2 这样的效果是MultiExtends实现了多重继承
 * Created by Mr_yyy on 2017/3/25.
 */
public class MultiExtends {
    private class E1 extends Example1{
        public void doExample() {
            super.doExample();
        }
    }
    private class E2 extends Example2{
        public void doExample() {
            super.doExample();
        }
    }

    public void doE() {
        new E1().doExample();
        new E2().doExample();
    }

    public static void main(String[] args) {
        new MultiExtends().doE();
    }
}
