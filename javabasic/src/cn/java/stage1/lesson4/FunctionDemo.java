package cn.java.stage1.lesson4;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        Function<String, Long> stringToLong = Long::valueOf;
        System.out.println(stringToLong.apply("1"));

        Function<Long, String> longToString = String::valueOf;
        System.out.println(longToString.apply(1l));

        // "1" -> 1L -> "1"
        Long value = stringToLong.compose(String::valueOf).apply(1l);
    }
}
