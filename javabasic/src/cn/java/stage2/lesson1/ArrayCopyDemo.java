package cn.java.stage2.lesson1;

import java.util.List;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        int value = Integer.MAX_VALUE;
        System.out.println(value);

        // int 在 Java 只有四个字节
        // long 和 double 是非线程安全的，两个4字节，高位和低位
        // Java 中默认是没有正整数（无符号整数）
        // C unsigned int

        List<String> values = List.of();
    }
}
