package cn.com.bate5.javasebasic;

public class H_InnerClass {
    // 1. 静态嵌套类 (Static Nested Class) 和内部类(Inner Class)的不同？
    /**
     *      静态嵌套类：Static Nested Class 是被声明为静态（static）的内部类，它可以不依赖于外部类实例被实例化。
     *      内部类：需要在外部类实例化后才能实例化，其语法看起来挺诡异的。
     */

    // 2. 下面的代码哪些地方会产生编译错误？
    /**
     *      注意：Java 中非静态内部类对象的创建要依赖其外部类对象，上面的面试题中 foo 和 main 方法都是静态方
     *      法，静态方法中没有 this，也就是说没有所谓的外部类对象，因此无法创建内部类对象，如果要在静态方法中创建内
     *      部类对象，可以这样做 new Outer().new Inner();
     */
}


class Outer{
    class Inner{

    }
    public static void foo(){
        // 报错
//        new Inner();
    }

    public void bar(){
        new Inner();
    }

    public static void main(String[] args) {
        new Outer().new Inner();
    }
}
