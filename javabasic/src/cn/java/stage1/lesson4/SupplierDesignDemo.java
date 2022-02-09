package cn.java.stage1.lesson4;

import java.util.function.Supplier;

/**
 *      接口定义：
 *          基本特点： 只出不进
 *          编程范式： 作为方法/构造函数、方法返回值
 *          使用场景： 数据来源，代码代替接口
 */
public class SupplierDesignDemo {
    public static void main(String[] args) {

        echo("hello world");

        echo2(SupplierDesignDemo::getMessage);

        getMessage(); // 及时返回数据

        Supplier<String> supplier = supplyMessage();   // 待执行熟悉

        supplier.get();   // 实际执行
    }

    public static String getMessage(){
        sleep();
        return "hello world";
    }

    public static Supplier<String> supplyMessage(){
        return SupplierDesignDemo::getMessage;
    }

    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void echo(String message){
        System.out.println(message);
    }

    public static void echo2(Supplier<String> message){
        System.out.println(message.get());
    }
}
