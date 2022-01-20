package cn.bingfa.producerconsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id = " + Thread.currentThread().getId());
        Random r = new Random();

        while (true){
            try {
                PCData data = queue.take();
                if (null != data){
                    int re = data.getData() * data.getData();   // 计算平方
                     System.out.println("{0}*{1}={2}" + data.getData() + re);
                    // MessageFormat.format();
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
    }
}
