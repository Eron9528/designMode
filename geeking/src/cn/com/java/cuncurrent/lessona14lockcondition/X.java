package cn.com.java.cuncurrent.lessona14lockcondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class X {
    private final Lock rtl = new ReentrantLock();
    int value;

    public int get(){
        // 获取锁
        rtl.lock();
        try{
            return value;
        }finally {
            rtl.unlock();
        }
    }

    public void addOne() {
        // 获取锁 rtl.lock();
        try {
            value += get() + 1;
        } finally {
            // 保证锁能释放
            rtl.unlock();
        }
    }
}
