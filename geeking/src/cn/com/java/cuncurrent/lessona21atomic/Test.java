package cn.com.java.cuncurrent.lessona21atomic;

import java.util.concurrent.atomic.AtomicLong;

public class Test {
    AtomicLong count = new AtomicLong(0);
    void add10K(){
        int idx = 0;
        while(idx++ < 10000){
            count.getAndIncrement();
        }
    }
}
