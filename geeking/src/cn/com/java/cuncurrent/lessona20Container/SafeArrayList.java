package cn.com.java.cuncurrent.lessona20Container;

import java.util.ArrayList;
import java.util.List;

public class SafeArrayList<T> {
    // 封装 ArrayList
    List<T> c = new ArrayList<>();
    // 控制访问路径
    synchronized T get(int idx){
        return c.get(idx);
    }

    synchronized void add(int idx, T t) {
        c.add(idx, t);
    }

    synchronized boolean addIfNotExist(T t){
        if(!c.contains(t)) {
            c.add(t); return true;
        } return false;
    }
}
