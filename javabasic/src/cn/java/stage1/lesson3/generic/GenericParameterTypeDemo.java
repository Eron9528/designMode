package cn.java.stage1.lesson3.generic;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class GenericParameterTypeDemo {
    public static void main(String[] args) {

        Container<String> a = new Container("String");

        // Error : Integer 不是 CharSequence 子类
//        Container<Integer> b = new Container(2);

        // 编译时：为什么不报错
        // StringBuffer 是 CharSequence 子类
        // String (参数) 也是 CharSequence 子类
        // 运行时：Object
        Container<StringBuffer> c = new Container("1");
        // 通过构造器传递参数是String类型，运行时都是Object ,没有问题
        System.out.println(c.getElement());
        // 不过当 c 对象申明类型为 Container<StringBuffer>, E 类型为 StringBuffer ,
        // 因此 set<E> , E 必须是 StringBuilder
        c.set(new StringBuffer("2019"));
        //Java 泛型对象操作时， 看申明对象泛型参数类型

        add(new ArrayList<>(), "hello");
        add(new HashSet<>(), 2);
        foreach(Arrays.asList("a","b"), System.out::println);


    }

    // 单边界
    // extends 声明他的上限
    public static class Container<E extends CharSequence> {
        private E element;

        public Container(E element){
            this.element = element;
        }

        public boolean set(E element){
            this.element = element;
            return true;
        }

        public E getElement() {
            return element;
        }

        // opertions
    }

    // 多界限泛型参数类型
    public static class C {

    }

    public static interface I {

    }

    public static interface I2 {

    }

    // 多界限泛型参数类型 extends 的第一个类型允许是具体类（也可以是接口）
    // 第二个或者更多参数类型必须是接口
    public static class Template <T extends C & I & I2> {

    }

    public static class TClass extends C implements I , I2{

    }

    // 把一个类型的元素，添加到集合中去
    public static <C extends Collection<E>, E extends Serializable> void add(C target, E element){
        target.add(element);
    }

    public static <C extends Iterable<E>, E extends Serializable> void foreach(C source, Consumer<E> consumer){
        for(E e : source){
            consumer.accept(e);
        }

    }




}
