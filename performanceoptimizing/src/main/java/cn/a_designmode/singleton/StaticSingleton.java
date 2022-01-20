package cn.a_designmode.singleton;

public class StaticSingleton {

    // 单例模式使用内部类来维护单例的实例，当本类初始化时，内部类不会被加载
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }
    private static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
