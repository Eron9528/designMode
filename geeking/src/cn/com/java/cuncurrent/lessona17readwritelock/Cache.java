package cn.com.java.cuncurrent.lessona17readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 读锁
    final Lock r = rwl.readLock();
    // 写锁
    final Lock w = rwl.writeLock();
    // 读缓存
    V get(K key){
        V v = null;
        r.lock();
        try{
            v = m.get(key);
        }finally {
            r.unlock();
        }
        // 缓存中存在，返回
        if (v != null){
            return v;
        }
        // 缓存中不存在，查询数据库
        w.lock();
        try{
            // 再次验证
            // 其他线程已经可能查过数据库了
            v = m.get(key);
            if (v==null){
                // 查询数据库
                v=null;// 省略代码
                m.put(key,v);
            }
        }finally {
            w.unlock();
        }
        return v;
    }
    // 写缓存
    V put(K key, V value){
        w.lock();
        try{
            return m.put(key,value);
        }finally {
            w.unlock();
        }
    }
}
