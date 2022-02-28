package cn.com.bate5.javasebasic.g_multithreading.b_concurrentnote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestCreateThreadPool {

    public static void main(String[] args) {
        /**
         *    固定大小连接池
         *       从上面的运行来看，我们Thread类都是在线程池中运行的，线程池在执行execute方法来执行Thread类中的run方法。
         *   不管execute执行几次，线程池始终都会使用2个线程来处理。不会再去创建出其他线程来处理run方法执行。这就是固定大小线程池。
         */
        //创建一个可重用固定线程数的线程池
//        ExecutorService pool = Executors.newFixedThreadPool(2);

        /**
         *       运行结果看出，可变任务线程池在执行execute方法来执行Thread类中的run方法。这里execute执行多次，线程池就会创建出多个线程
         *    来处理Thread类中run方法。所有我们看到连接池会根据执行的情况，在程序运行时创建多个线程来处理，这里就是可变连接池的特点。
         */
//        ExecutorService pool = Executors.newCachedThreadPool();

        /**
         *      运行结果看出，单任务线程池在执行execute方法来执行Thread类中的run方法。不管execute执行几次，线程池始终都会使用单个线程来处理。
         *      补充：在java的多线程中，一但线程关闭，就会成为死线程。关闭后死线程就没有办法在启动了。再次启动就会出现
         *      异常信息：Exception in thread "main" java.lang.IllegalThreadStateException。那么如何解决这个问题呢？
         *                我们这里就可以使用Executors.newSingleThreadExecutor()来再次启动一个线程。（面试）
         */
        //创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.shutdown();

        /**
         *  除了在上面的三种创建方式，Executors 还可以在执行某个线程时，定时操作
         */

        // 创建一个线程池，它可以在给定延迟后运行命令或者定期地执行
        ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(2);
        Thread t6 = new MyThread();
        Thread t7 = new MyThread();
        // 在10s 之后执行
        pool2.schedule(t6, 10, TimeUnit.MILLISECONDS);
        pool2.schedule(t7, 10, TimeUnit.MILLISECONDS);


    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 正在执行。。。 ");
    }
}
