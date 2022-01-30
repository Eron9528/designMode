package cn.java.lesson2;


import java.lang.reflect.Field;

public class StringDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        /** 常量化是原生类型支持，赋值方式 */
        /** 常量 语法特性  对象类型常量化 */
        String value = "Hello";

        // 面向对象写法， 一切对象需要new

        // 合法的写法
        String value2 = new String("Hello");

        System.out.println(value);
        System.out.println(value2);

        // 从 java 1.5 开始对象属性可以通过反射修改
        char[] chars = "World".toCharArray();
        // 获取 String 类中的 value 字段
        Field valueField = String.class.getDeclaredField("value");
        // 设置 private 字段可以被修改
        valueField.setAccessible(true);

        System.out.println(value);
        System.out.println(value2);



    }
}
