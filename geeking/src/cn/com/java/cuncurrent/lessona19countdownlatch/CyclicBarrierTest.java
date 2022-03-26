package cn.com.java.cuncurrent.lessona19countdownlatch;

import java.util.Vector;
import java.util.concurrent.*;

public class CyclicBarrierTest {
    // 订单队列
    Vector<Pos> pos;
    // 派送但队列
    Vector<Dos> dos;
    // 执行回调的线程池
    ExecutorService executor = Executors.newFixedThreadPool(1);
    final CyclicBarrier barrier = new CyclicBarrier(2, ()->{
        executor.execute(()->{check();});
    });


    void check(){
        Pos p = pos.remove(0);
        Dos d = dos.remove(0);
        // 执行对账操作
        // 写入差异库
    }

    void checkAll(){
        // 循环查询订单库
        Thread t1 = new Thread(()->{
            while(true){
                // 查询订单库
                pos.add(Pos.getPorders());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }
}
