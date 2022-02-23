package cn.com.javasehigh.c_designmode_garbagecollect.a_designmode;

public class B_HungrySingleton {
    // 直接创建对象
    public static A_LazySingleton instance = new A_LazySingleton();

    // 私有化构造函数
    public B_HungrySingleton(){}

    public static A_LazySingleton getInstance(){
        return instance;
    }
}
