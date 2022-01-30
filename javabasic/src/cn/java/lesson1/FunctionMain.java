package cn.java.lesson1;

public class FunctionMain {

    /** 2. 知识点2.  包访问性
     *     在 Java 9 之前：访问性
     *     public :  all
     *     protected : 继承 + 同包
     *     default : 同包
     *     private : 当前类
     *
     *     Java 9 之后：访问性
     */


    public static void main(String[] args) {

        /** 1. 知识点1. byte(8) char(16) short(16) int(32) long(64)区别
         *     面试题：1.多线程编程环境下 long 和 double 可能导致线程不安全吗？
         *
         *     首先我们分析一下 volatile ,它具有可见性，原子性和有序性
         *     a.他是保证了可见性，volatile 提供了happen-before 的保证，确保一个线程的修改对其他线程是可见的
         *     b.原子性是具有不可分割的特性
         *     c.这个关键字会禁止指令重排优化，也就是说，在volatile 变量的赋值操作后面会有一个内存屏障（生成的
         *       汇编代码上），读操作不会重排序到内存屏障之前。
         *
         *     java 中除了long 和 double 之外的所有基本类型的 读和赋值操作都是原子操作，是线程安全的，而64 位
         *     的 long 和 double 变量由于会被 JVM 分离成两个32 位来进行操作，会出现两次写操作，就造成了错位的
         *     可能，所以不具有原子性，会产生字撕裂的问题，当你定义 long 或者 double 关键字时， 如果使用volaite
         *     关键字，就会活得原子性。
         *
         * */






    }
}
