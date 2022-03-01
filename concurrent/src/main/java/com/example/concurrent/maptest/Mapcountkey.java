package com.example.concurrent.maptest;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Mapcountkey {

    // 循环次数
    private static int LOOP_COUNT = 10000000;
    // 线程数量
    private static int THREAD_COUNT = 10;
    // 元素数量
    private static int ITEM_COUNT = 10;

    private static Map<String,Long> normaluse() throws InterruptedException {
        ConcurrentHashMap<String,Long> freqs = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(()-> IntStream.rangeClosed(1,LOOP_COUNT).parallel().forEach(i->{
            // 获得一个随机key
            String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
            synchronized (freqs){
                if (freqs.containsKey(key)){
                    // key 存在则+1
                    freqs.put(key,freqs.get(key)+1);
                }else {
                    freqs.put(key,1L);
                }
            }

        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return freqs;
    }

    private Map<String, Long> gooduse() throws InterruptedException {
        ConcurrentHashMap<String , LongAdder> freqs = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(()->IntStream.rangeClosed(0,LOOP_COUNT).forEach(i->{
            String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
            // 利用 computeIfAbsent() 方法来实例化 LongAdder, 然后利用 LongAdder 来进行线程安全计数
            freqs.computeIfAbsent(key,k -> new LongAdder()).increment();
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1,TimeUnit.HOURS);
        // 因为我们的Value

     }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(normaluse());
    }
}
