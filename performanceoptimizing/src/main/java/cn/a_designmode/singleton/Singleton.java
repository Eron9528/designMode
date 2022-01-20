package cn.a_designmode.singleton;

public class Singleton {

    // 单例模式的核心在于通过一个接口返回唯一的对象实例
    private Singleton(){
        System.out.println("Singleton is create");
    }

    // 单例类必须要有一个 private 访问级别的构造函数，只有这样，才能确保单例不会在系统中的其他代码内被实例化
    // 其次，instance 成员变量和getInstance () 方法必须是static
    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    // 如果这个单例类还有别的方法，如果系统初始化的时候还需要用到此单例类中的其他方法
    // 因为这个类是 static 的，所以在JVM 加载单例类时， 单例对象就会被建立。
    public static void createString(){
        System.out.println("createString in Singleton");
    }



}
