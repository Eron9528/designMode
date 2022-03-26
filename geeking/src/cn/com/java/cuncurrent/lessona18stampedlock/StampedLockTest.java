package cn.com.java.cuncurrent.lessona18stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    final StampedLock sl = new StampedLock();
    void get(){
        // 获取/ 释放悲观锁示意代码
        long stamp = sl.readLock();
        try{
            // 省略代码
        }finally{
            sl.unlockRead(stamp);
        }
        // 获取/ 释放写锁示意代码
        long stamp2 = sl.writeLock();
        try{
            // 省略代码
        }finally{
            sl.unlockWrite(stamp2);
        }
    }

}
