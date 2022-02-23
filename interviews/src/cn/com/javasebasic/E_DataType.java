package cn.com.javasebasic;

public class E_DataType {
    public static void main(String[] args) {

        // 1. Java的基本数据类型都有哪些各占几个字节？
        /**
         *      整型：byte, short, int, long
         *      浮点型：float, double
         *      字符型：char
         *      布尔型：boolean
         */


        // 2. String是基本数据类型吗？
        /**
         * String是引用类型，底层用char数组实现的。
         */


        // 3. short s1 = 1; s1 = s1 + 1; 有错吗?short s1 = 1; s1 += 1有错吗;
        /**
         * 前者不正确，后者正确。对于 short s1 = 1; s1 = s1 + 1;由于1是 int 类型，
         * 因此 s1+1 运算结果也是 int 型，需要强制转换类型才能赋值给short型。而 short s1 = 1; s1 += 1;
         * 可以正确编译，因为 s1+= 1;相当于 s1 = (short)(s1 + 1);其中有隐含的强制类型转换
         */

        System.out.println("=============题目1===============");
        short s1 = 1;
        s1 = (short) (s1 +1);


        // 4. int 和 和 Integer有什么区别？
        /**
         * Java是一个近乎纯洁的面向对象编程语言，但是为了编程的方便还是引入了基本数据类型，
         * 为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class），
         * int 的包装类就是 Integer，从 Java 5 开始引入了自动装箱/拆箱机制，使得二者可以相互转换。
         */


        // 5. 下面Integer类型的数值比较输出的结果为？
        /**
         * 如果整型字面量的值在-128 到 127 之间，那么不会 new 新的 Integer 对象，
         * 而是直接引用常量池中的 Integer 对象，所以上面的面试题中 f1==f2 的结果是 true，而 f3==f4 的结果是 false。
         */
        System.out.println("=============题目2===============");
        Integer f1 = 100,f2=100,f3=150,f4=150;
        System.out.println(f1==f2);
        System.out.println(f3==f4);


        // 6. String类常用方法
        /**
         *    .trim()     返回去除前后空格
         *    .getByte()  转换为Byte 数组
         */


        // 7. String、StringBuffer、StringBuilder的区别？
        /**
         *    可变不可变 ：
         *       String：字符串常量，在修改时不会改变自身；若修改，等于重新生成新的字符串对象。
         *       StringBuffer：在修改时会改变对象自身，每次操作都是对StringBuffer对象本身进行修改，
         *                     不是生成新的对象；使用场景：对字符串经常改变情况下，主要方法：append（），insert（）等。
         *
         *    线程是否安全 :
         *       String：对象定义后不可变，线程安全。
         *       StringBuffer：是线程安全的（对调用方法加入同步锁），执行效率较慢，适用于多线程下操作字符串缓冲区大量数据。
         *       StringBuilder：是线程不安全的，适用于单线程下操作字符串缓冲区大量数据。
         *
         *    共同点:
         *       StringBuilder与StringBuffer有公共父类AbstractStringBuilder(抽象类)。
         *       StringBuilder、StringBuffer的方法都会调用AbstractStringBuilder中的公共方法，
         *       如super.append(...)。只是StringBuffer会在方法上加synchronized关键字，进行同步。最后，
         *       如果程序不是多线程的，那么使用StringBuilder效率高于StringBuffer。
         *
         */


        // 8. 数据类型之间的转换
        /**
         *     字符串如何转基本数据类型？
         *     基本数据类型如何转字符串？
         */

        System.out.println("=============题目3===============");
        String a = "1";
        Integer.parseInt(a);
        Integer.valueOf(a);









    }
}
