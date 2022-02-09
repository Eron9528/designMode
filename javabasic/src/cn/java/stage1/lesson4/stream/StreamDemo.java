package cn.java.stage1.lesson4.stream;

import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        count(1,2,3,4,5);
    }

    public static void count(Integer... numbers){
        Stream.of(numbers).reduce(Integer::sum).map(String::valueOf).ifPresent(System.out::println);
    }

}
