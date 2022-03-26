package cn.com.java.cuncurrent.lessona18stampedlock;

import java.util.concurrent.locks.StampedLock;

public class Point {
    private int x, y;
    final StampedLock sl = new StampedLock();
    // 计算到原点的距离
    double distanceFromOrigin(){
        // 乐观读
        long stamp = sl.tryOptimisticRead();
        // 读入局部变量
        // 读的过程数据可能被修改
        int curX = x, curY = y;
        // 判断执行读操作期间，
        // 是否存在写操作，如果存在
        // 则 sl.validate 返回 false
        if (!sl.validate(stamp)){
            // 升级成悲观读锁
            stamp = sl.readLock();
            try{
                curX = x;
                curY = y;
            }finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY * curY);
    }

}
