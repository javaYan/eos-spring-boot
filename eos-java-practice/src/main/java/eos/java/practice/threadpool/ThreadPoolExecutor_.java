package eos.java.practice.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanyuyu on 2017/1/12.
 */
public class ThreadPoolExecutor_ {

    //核心线程数
    int corePoolSize;
    //最大线程数
    int maximumPoolSize;
    //介于core和max之间的线程的空闲存活时间
    long keepAliveTime;
    //介于core和max之间的线程的空闲存活时间单位
    TimeUnit unit;
    //阻塞队列
    BlockingQueue<Runnable> workQueue;

    /**
     * Description :
     * <p>
     *     1.corePoolSize = maximumPoolSize， 代表线程为固定线程数
     *     2.workQueue为 LinkedBlockingQuere时，为无界队列，线程数不会超过 corePoolSize
     *     3.workQueue为 SynchronousQueue时，直接提交， 一般情况下需要设置 maximumPoolSize > corePoolSize
     *          以避免任务的无法提交而导致任务丢失或者失败
     *     4.workQueue为 ArrayBlockingQueue 时，为有界队列，任务在corePoolSize满时 会自动保存到队列中以排队等待，
     *          当队列满时，创建新线程直到总线程数达到 maximumPoolSize
     * </p>
     */
}
