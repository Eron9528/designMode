package cn.com.java.cuncurrent.lessona19countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountdownlatchTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建 2 个线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        while(true){   // 存在未对账订单
            // 计数器初始化为2
            CountDownLatch latch = new CountDownLatch(2);
            // 查询未对账订单
            executor.execute(()->{
                Pos pos = Pos.getPorders();
                latch.countDown();
            });
            // 查询派送单
            executor.execute(()->{
                Dos dos = Dos.getDorders();
                latch.countDown();
            });
            // 等待两个查询操作结束
            latch.await();
        }
    }


}

class Pos{
    static Pos getPorders() {
        return new Pos();
    }
}
class Dos{
    static Dos getDorders() {
        return new Dos();
    }
}
