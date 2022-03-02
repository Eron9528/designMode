package com.example.concurrent.maptest;

import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CopyOnWriteTest {

    public static void main(String[] args) {
        testwrite();
        testread();
    }

    public static void testwrite(){
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
        StopWatch stopWatch = new StopWatch();
        int loopCount = 100000;
        stopWatch.start("Write:copyOnWriteArrayList");
        // 循环100000次往并发 CopyOnWriteArrayList写入随机数据
        IntStream.rangeClosed(0, loopCount).parallel().forEach(__->copyOnWriteArrayList.add(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        stopWatch.start("Write:synchronizedArrayList");
        // 循环100000次并发往加锁的ArrayList 写入随机元素
        IntStream.rangeClosed(0,loopCount).parallel().forEach(__->synchronizedArrayList.add(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println("copy list size:"+copyOnWriteArrayList.size());
        System.out.println("synchronized list size:"+synchronizedArrayList.size());
    }

    private static void addAll(List<Integer> list){
        list.addAll(IntStream.rangeClosed(1,1000000).boxed().collect(Collectors.toList()));
    }

    // 测试并发读性能
    public static void testread(){
        // 创建两个测试对象
        List<Integer> copyWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
        // 填充数据
        addAll(copyWriteArrayList);
        addAll(synchronizedArrayList);
        StopWatch stopWatch = new StopWatch();
        int loopCount = 1000000;
        int count = copyWriteArrayList.size();
        stopWatch.start("Read:copyOnWriteArrayList");
        // 循环1000000次并发从 CopyOnWriteArrayList 随机查询元素
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__->copyWriteArrayList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();
        stopWatch.start("Read:sychronizedArrayList");
        IntStream.rangeClosed(1,loopCount).parallel().forEach(__->synchronizedArrayList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        System.out.println("copy list size:"+copyWriteArrayList.size());
        System.out.println("synchronized list size:"+synchronizedArrayList.size());
    }


}
