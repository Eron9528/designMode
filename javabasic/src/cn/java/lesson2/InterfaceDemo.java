package cn.java.lesson2;

import java.io.Serializable;

public class InterfaceDemo {

    public static void main(String[] args) {

        // 强类型约束
        println(1);
        // String 既是 CharSequence 也是 Serializable
        println((CharSequence) "hello");
    }

    private static void println(Serializable id){

    }

    private static void println(CharSequence cs){

    }
}
