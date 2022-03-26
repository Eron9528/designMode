package cn.com.java.cuncurrent.lessona16semaphore;

import java.util.concurrent.Semaphore;

public class CountTest {
    static int count = 0;
    // 初始化信号量
    static final Semaphore s = new Semaphore(1);
    // 用信号量保持互斥
    static void addOne() throws InterruptedException {
        s.acquire();
        try {
            count+=1;
        }finally {
            s.release();
        }
    }
}
