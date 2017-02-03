package eos.java.practice.reentrantlock;

import org.junit.Test;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class ReentrantLockTest {
    @Test
    public void testNormal() {
        int i = 10;
        while( i-- > 0 ) {
            Thread thread = new Thread(new Normal());
            thread.start();
        }
        try {
            Thread.sleep(15000L);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testTryLock() {
        int i = 20;
        while( i-- > 0 ) {
            Thread thread = new Thread(new TryLock());
            thread.start();
        }
        try {
            Thread.sleep(15000L);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testAwaitSingal() {


        Thread thread0 = new Thread(new AwaitSignal());
        thread0.start();

        //thread1 进入阻塞，需要唤醒才能继续
        try {
            Thread.sleep(3000L);
            AwaitSignal.lock.lock();
            System.out.println("Main Thread signal thread0");
            AwaitSignal.condition.signal();
            AwaitSignal.lock.unlock();

            Thread.sleep(5000L);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {

        }
    }

    @Test
    public void testAwaitSingal02() {

        int i = 10;
        while ( i-- > 0 ) {
            Thread thread = new Thread(new AwaitSignal());
            thread.start();
        }

        //threads 进入阻塞，需要唤醒才能继续
        try {
            Thread.sleep(3000L);
            AwaitSignal.lock.lock();
            System.out.println("Main Thread signal thread0");
            AwaitSignal.condition.signalAll();
            //此处如果不立即释放锁，虽然线程已经唤醒，但由于没有得到锁，依然不能执行
            //所以一般signal后 需要释放锁以保证其他被唤醒的线程获取锁并进一步执行
            AwaitSignal.lock.unlock();
            Thread.sleep(10000L);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
