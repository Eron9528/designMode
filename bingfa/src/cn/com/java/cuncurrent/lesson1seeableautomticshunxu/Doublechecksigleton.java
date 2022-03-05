package cn.com.java.cuncurrent.lesson1seeableautomticshunxu;

public class Doublechecksigleton {

}
// 双重检查版
class Singleton{
    // 最终是加入 volatile 禁止指令重排序
    private volatile static Singleton instance = null;
    public Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

// 静态内部类版
class MySingleton{
    // 内部类
    private static class MySingletonHandler{
        private static MySingleton instance = new MySingleton();
    }
    public static MySingleton getInstance(){
        return MySingletonHandler.instance;
    }
}
