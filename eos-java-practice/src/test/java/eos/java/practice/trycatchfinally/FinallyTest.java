package eos.java.practice.trycatchfinally;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yanyuyu on 2017/3/3.
 */

/**
 * try catch finally 中 finally 如果有return的话 会最终返回finally return的结果 （doFin3测试可以看出）
 *                      finally 如果没有return 并且方法的返回值是基本类型，finally中如果对该返回变量进行改变，则不会影响方法返回值（doFin2测试可以看出）
 *                      finally 如果没有return 并且方法的返回值是对象类型，finally中如果对该返回变量进行改变，则会影响方法返回值，返回值会是finally改变后的对象（doFin4测试可以看出）
 *
 */
class Fin {
    public int doFin1(int dividend,int divisor) {
        int value = 0;
        try {
            value = dividend / divisor;
            return value;
        } catch (Exception e) {
            System.out.println("catch exception !");
            return value;
        } finally {
            System.out.println("finally output message !");
        }
    }

    public int doFin2(int dividend,int divisor) {
        int value = 0;
        try {
            value = dividend / divisor;
            return value;
        } catch (Exception e) {
            System.out.println("catch exception !");
            return value;
        } finally {
            System.out.println("finally output message !");
            value = -1;
        }
    }

    public int doFin3(int dividend,int divisor) {
        int value = 0;
        try {
            value = dividend / divisor;
            return value;
        } catch (Exception e) {
            System.out.println("catch exception !");
            return value;
        } finally {
            System.out.println("finally output message !");
            value = -1;
            return value;
        }
    }

    public FinallyTest.Obj doFin4() {
        FinallyTest.Obj obj = new FinallyTest().new Obj(1,"xiaoli");
        try {
            return obj;
        } catch (Exception e) {
            System.out.println("catch exception !");
            return obj;
        } finally {
            System.out.println("finally output message !");
            obj.setId(222);
            obj.setName("haha");
        }
    }

    //finally块一般情况都会执行，只有在调用了System.exit(0)或者系统突然断电了
    public void doFin5() {
        try {
            System.out.println("try output message !");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("catch exception !");
        } finally {
            System.out.println("finally output message !");
        }
    }
}

public class FinallyTest {
    @Test
    public void testNormal_1() {
        Fin fin = new Fin();
        int result = fin.doFin1(10, 2);
        System.out.println(result);
    }

    @Test
    public void testError_1() {
        Fin fin = new Fin();
        int result = fin.doFin1(10, 0);
        System.out.println(result);
    }

    @Test
    public void testNormal_2() {
        Fin fin = new Fin();
        int result = fin.doFin2(10, 2);
        System.out.println(result);
    }

    @Test
    public void testError_2() {
        Fin fin = new Fin();
        int result = fin.doFin2(10, 0);
        System.out.println(result);
    }

    @Test
    public void testNormal_3() {
        Fin fin = new Fin();
        int result = fin.doFin3(10, 2);
        System.out.println(result);
    }

    @Test
    public void testError_3() {
        Fin fin = new Fin();
        int result = fin.doFin3(10, 0);
        System.out.println(result);
    }

    @Test
    public void testError_Obj() {
        Fin fin = new Fin();
        Obj obj = fin.doFin4();
        System.out.println(obj);
    }

    @Test
    public void testError_5() {
        Fin fin = new Fin();
        fin.doFin5();
    }



    @Getter @Setter @ToString
    class Obj {
        private int id;
        private String  name;
        public Obj(int id,String name) {
            this.id = id;
            this.name = name;
        }
    }
}
