package cn.com.basicSE;

import java.util.List;

public class ConstallyAPI {

    public static void main(String[] args) {

        // 1. Math.round(11.5)等于多少？Math.round(- 11.5) 又等于多少?(2017-11-14-wl)
        System.out.println("=============题目1===============");
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));


        // 2. switch是否能作用在byte上，是否能作用在long上，是否能作用在String上?
        /**
         *  Java5以前switch(expr)中，expr 只能是 byte、short、char、int。从 Java 5 开始，
         *  Java 中引入了枚举类型，expr 也可以是 enum 类型。
         *
         *  从Java 7 开始，expr 还可以是字符串（String），但是长整型（long）在目前所有的版本中都是不可以的。
         */
        System.out.println("=============题目2===============");
        byte b = 'b';
        switch (new Byte(b)){
            case 'b' :
                System.out.println("true");
                break;
        }


        // 3. 数组有没有length() 方法？String有没有length() 方法？
        /**
         *  数组没有length()方法，而是有length 的属性。String有length()方法。JavaScript 中，
         *  获得字符串的长度是通过 length 属性得到的，这一点容易和 Java 混淆。
         *
         */


        // 4. String 、StringBuilder 、StringBuffer的区别？
        /**
         *  Java平台提供了两种类型的字符串：String和StringBuffer/StringBuilder，它们都可以储存和操作字符串，
         *  StringBuilder是Java5中引入的，它和 StringBuffer的方法完全相同，区别在于它是在单线程环境下使用的，
         *  因为它的所有方法都没有被synchronized修饰，因此它的效率理论上也比StringBuffer要高。
         */


        // 5. 什么情况下用“+”运算符进行字符串连接比调用 StringBuffer/StringBuilder 对象的append方法连接字符串性能更好？
        /**
         *  没有，StringBuilder 比 + 性能好， + 在 for 循环可能会引起创建多个StringBuilder 的问题，
         *  + 号和 StringBuilder 混合使用直接回导致创建多个StringBuilder
         */


        // 6. 请说出下面程序的输出
        System.out.println("=============题目3===============");

        String s = new StringBuilder("Programming").toString();
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s.intern());
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());


        System.out.println("=============题目2===============");




    }
}
