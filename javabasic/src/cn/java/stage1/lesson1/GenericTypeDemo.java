package cn.java.stage1.lesson1;

import java.util.Collections;
import java.util.List;

public class GenericTypeDemo {

    /**
     * @param <S> 转换类型
     * @param <T> 目标类型
     */
    public interface Convert<S,T> {

        T convert(S source);


    }

    public static void main(String[] args) {
        List<Integer> data = Collections.emptyList();
        List data2 = Collections.emptyList();
        data = data2;
    }


    /**  3. 知识点3  List,List<> 会实现重载吗
     *
     *      方法前签名冲突，使用List, 在方法上于List<> 一致。会产生编译错误
     *       例如 doConvert 方法
     */
//    public static void doConvert(List<String> s){
//
//    }
//    public static void doConvert(List b){
//
//    }

    /**  4.知识点4   泛型擦除机制是什么
     *      Java 泛型机制原理，泛型擦除机制
     *      原理：
     *          Java 泛型jdk 5 引入的一种机制。为了向下兼容，所以java 虚拟机是不支持泛型的，也就是说
     *          java 泛型是一种伪泛型机制。
     *      泛型的擦除机制：
     *          伪泛型机制就是说：在编译期间把泛型的信息全部擦除掉了，所有泛型都变成了原始的类型 Object,
     *          在运行期间就不存在泛型的信息。
     *      编译器怎么擦除泛型的？
     *          1.检查泛型的类型，获取目标泛型
     *          2.擦除类型变量，并替换为限定类型
     *              a. 如果没有指定类型变量（）,则用Object为原始类型
     *              b.如果限定类型变量（），则用A作为原始类型
     *              c.如果有多个限定类型（<T extends A & B & C >），则用第一个边界A作为原始类型
     *          3.必要时插入类型转换以保持类型安全
     *          4.生成桥方法用在扩展的时候保持多态性
     *       泛型的副作用？
     *          1.使用泛型后，不能使用基本数据类型（byte，short，int ，long，float，double，boolean，char）；
     *              a. 原因：因为擦除后变成Object，而Object无法存放int类型
     *          2.不能使用 instanceof运算符
     *              a. 原因：因为擦除后只剩下原始类型，泛型信息不存在
     *          3. 泛型在静态方法和静态类使用问题
     *              a. 泛型静态参数创建时候报错：泛型的静态参数在创建的时候就要确定参数
     *              b.泛型静态方法创建成功：方法在调用的时候在确定泛型类型
     *          4. 泛型类型中方法冲突
     *              a.比如equals方法：泛型擦除后变成了Object，object方法有equals方法，相当于重新定义equals方法
     */


}
