package cn.com.java.cuncurrent.lesson3sychronized;

public class X {
    // 修饰非静态方法
    synchronized void foo(){
        // 临界区
    }
    // 修饰静态方法
    synchronized static void bar(){
        // 临界区
    }
    // 修饰代码块
    Object obj = new Object();
    void baz(){
        synchronized (obj){
            // 临界区
        }
    }

}
