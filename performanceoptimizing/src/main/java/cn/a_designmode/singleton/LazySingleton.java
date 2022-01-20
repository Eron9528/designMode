package cn.a_designmode.singleton;

public class LazySingleton {
    private LazySingleton(){
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    private static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
