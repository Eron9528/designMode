package cn.com.bate5.javasehigh.c_designmode_garbagecollect.a_designmode;

public class A_LazySingleton {

    private static volatile A_LazySingleton singleton = null;

    A_LazySingleton(){}

    public static A_LazySingleton getInstance(){
        if (singleton == null){
            synchronized (A_LazySingleton.class){
                singleton = new A_LazySingleton();
            }
        }
        return singleton;
    }

}
