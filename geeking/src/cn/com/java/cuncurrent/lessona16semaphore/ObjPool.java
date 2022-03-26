package cn.com.java.cuncurrent.lessona16semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class ObjPool<T, R> {
    // 用信号量实现限流器
    final Semaphore sem ;
    final List<T> pool;
    // 构造函数
    public ObjPool(int size, T t) {
        pool = new Vector<T>(){};
        for(int i=0; i<size; i++){
            pool.add(t);
        }
        sem = new Semaphore(size);
    }
    // 利用对象池里的对象，调用 func
    void exec(Consumer<T> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try{
            t = pool.remove(0);
            func.accept(t);
        }finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建对象池
        ObjPool<Long, String> objPool = new ObjPool<Long,String>(5, (long) 2);
        // 通过从对象池获取 t , 之后执行
        objPool.exec(x->{
            System.out.println(x);
        });

    }
}
