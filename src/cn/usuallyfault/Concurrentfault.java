package cn.usuallyfault;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Concurrentfault {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(gooduse());
    }

    //循环次数
    private static int LOOP_COUNT = 10000000;
    // 线程数量
    private static int THREAD_COUNT = 10;
    // 元素数量
    private static int ITEM_COUNT = 10;

    private static Map<String,Long> gooduse() throws InterruptedException {
        ConcurrentHashMap<String,LongAdder> freqs = new ConcurrentHashMap(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(()-> IntStream.rangeClosed(1,LOOP_COUNT).parallel().forEach(i->{
            String item = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
            freqs.computeIfAbsent(item,(k)->new LongAdder()).increment();
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return freqs.entrySet().stream().collect(Collectors.toMap(
                e->e.getKey(),
                e->e.getValue().longValue()
        ));
    }
}
