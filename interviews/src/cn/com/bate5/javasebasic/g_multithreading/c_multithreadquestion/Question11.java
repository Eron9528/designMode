package cn.com.bate5.javasebasic.g_multithreading.c_multithreadquestion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question11 {
    /**
     * Lock可以让等待锁的线程响应中断，Lock获取锁，之后需要释放锁。如下代码，多个线程不可访问同一个类中的2个加了Lock锁的方法。
     * 使用synchronized时，当我们访问同一个类对象的时候，是同一把锁，所以可以访问该对象的其他synchronized方法。
     */

    private int count =0;
    private Lock lock = new ReentrantLock(); // 设置 Lock 锁

    public Runnable run1 = new Runnable() {
        @Override
        public void run() {
            lock.lock();
            while (count < 1000){
                // 打印是否执行该方法
                System.out.println(Thread.currentThread().getName() + "run1:" + count++);
            }
            lock.unlock();
        }
    };

    public Runnable run2 = new Runnable() {
        @Override
        public void run() {
            lock.lock();
            while (count < 1000){
                System.out.println(Thread.currentThread().getName() + "run2" + count++);
            }
            lock.unlock();
        }
    };

    public Runnable run3 = new Runnable() {
        @Override
        public void run() {
            synchronized (this){
                while (count < 1000){
                    // 打印是否执行该方法
                    System.out.println(Thread.currentThread().getName() + "run3:" + count++);
                }
            }

        }
    };
    public Runnable run4 = new Runnable() {
        @Override
        public void run() {
            synchronized (this){
                while (count < 1000){
                    // 打印是否执行该方法
                    System.out.println(Thread.currentThread().getName() + "run4:" + count++);
                }
            }

        }
    };

    public static void main(String[] args) {
        Question11 question11a = new Question11();
        new Thread(question11a.run1).start();
        new Thread(question11a.run2).start();
//        new Thread(question11a.run3).start();
//        new Thread(question11a.run4).start();
    }
}
