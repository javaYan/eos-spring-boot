package eos.java.practice.readwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class ReadWrite {
    /**
     * 读写锁：
     * 读-读 并行   如果有大量的耗时的读操作，则读写锁的优势很明显
     * 读-写 串行
     * 写-写 串行
     */
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    /**
     * 模拟读操作
     * @param lock
     * @return
     */
    public Object read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(100L);
            System.out.println(lock.getClass().getName() + " read completed " + System.currentTimeMillis());
            return "this is read value";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;

    }

    /**
     * 模拟写操作
     * @param lock
     * @param value
     */
    public void write(Lock lock, int value) {
        try {
            lock.lock();
            Thread.sleep(10L);
            System.out.println(lock.getClass().getName() + " write completed " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        final ReadWrite demo = new ReadWrite();
        Runnable readWriteRunnable = new Runnable() {
            @Override
            public void run() {
                demo.read(readLock);
                demo.write(readLock,10);
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i=0; i < 100; i ++) {
            service.submit(readWriteRunnable);
        }

    }
}
