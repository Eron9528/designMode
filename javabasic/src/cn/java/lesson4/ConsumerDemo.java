package cn.java.lesson4;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        consumer.accept("Hello,World");
        Consumer<String> consumer2 = ConsumerDemo::echo;
        consumer2.andThen(consumer).andThen(consumer2).andThen(consumer).accept("xiao2");
    }

    private static void echo(String message){
        System.out.println("echo:"+message);
    }
}
