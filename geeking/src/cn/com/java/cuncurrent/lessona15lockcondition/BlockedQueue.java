package cn.com.java.cuncurrent.lessona15lockcondition;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    // 条件变量；队列不满
    final Condition notFull = lock.newCondition();
    // 条件变量； 队列已满
    final Condition notEmpty = lock.newCondition();
    BlockingQueue<T> blockingQueue = new ArrayBlockingQueue<T>(10);
    // 入队
    void enq(T x) throws InterruptedException {
        lock.lock();
        try{
            while(blockingQueue.size() == 10){
                // 等待队列不满
                notFull.await();
            }
            // 省略入队操作
            // 入队后，通知可出队
            notEmpty.signal();

        }finally {
            lock.unlock();
        }
    }
    // 出队
    void deq() throws InterruptedException {
        lock.lock();
        try{
            while (blockingQueue.isEmpty()){
                notEmpty.await();
            }
            notFull.signal();
        }finally {
            lock.unlock();
        }

    }
}
