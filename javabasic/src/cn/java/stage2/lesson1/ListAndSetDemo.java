package cn.java.stage2.lesson1;

import java.util.HashSet;
import java.util.Set;

public class ListAndSetDemo {
    public static void main(String[] args) {
        // HashSet 并不能保证顺序
        Set<String> values = new HashSet<>();
        // 字符场景可能会导致一些误导
        values.add("a");
        values.add("b");
        values.add("c");
        values.forEach(System.out::println);

        // 以上例子是 ASCII 码
        // HashSet 或者 HashMap 采用对象 HashCode
        // String hashCode 由 char[] 数组构建

        // 在Java 中两个char 相当于一个int
        // 汉字用一个int  四个字节表示
    }
}
