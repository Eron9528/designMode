package cn.com.questionfrommashibing.javabasic;

import cn.com.bate5.javasebasic.C_Execption;

import java.util.Collections;

public class QuestionMain {

    // 1.  java 对象有哪些特征
    /**
     *    封装 增加了代码的复用性
     *    继承 增加了代码的复用性
     *    多态 增加了代码的健壮性，灵活性，可移植性
     */

    // 2.  ArrayList 和 LinkedList 有什么区别
    /**
     *      都实现了 List 接口， 他们有一下不同点：
     *      ArrayList 是基于索引的数据接口，它的底层是数组。它可以已 O(1) 时间复杂度对元素进行随机访问。与此对应，
     *      LinkedList 是以元素列表的形式存储它的数据，每一个元素都和它前一个和后一个元素链接在一起，在这种情况
     *      下，查找某个元素的时间复杂度为 O(n).
     *      相对于ArrayList , LinkedList 的插入，添加，删除操作速度更快，因为当元素被添加到集合的任意位置的时候，
     *      不需要想数组那样重新计算大小或者更新索引。
     *      LinkedList 比 ArrayList 更占内存，因为LinkedList 为一个节点存储了两个引用，一个指向前一个元素，一个指向
     *      下一个元素。
     *      什么场景下更适宜使用 LinkedList 而不用 ArrayList
     *      1). 你的应用不会随机访问数据，因为如果你需要 LinkedList 中的第 n 个元素的时候，你需要从第一个元素顺序数
     *      到第 n 个数据，然后读取数据。
     *      2). 你的应用更多的插入和删除元素，更少的读取数据。因为插入和删除元素不涉及重排数据，所以它比ArrayList 要快。
     */

    // 3.  高并发中的集合有哪些问题
    /**
     *      第一代线程安全集合类
     *          Vector、Hashtable
     *          是怎么保证线程安全的：使用 synchronized 修饰方法
     *          缺点： 效率低下
     *      第二代线程非安全集合类
     *          ArrayList、HashMap
     *          线程不安全，但是性能好，用来代替Vector、Hashtable
     *          使用ArrayList,HashMap 需要线程安全怎么办？
     *          使用Collections.synchronizedList(list),Collections.synchronizedMap(map)
     *          底层使用 synchronized 代码块锁，虽然也锁住了所有代码，但是锁在方法里面，并锁在方法外面，
     *          性能可以理解为稍稍有所提升。毕竟方法本升就需要分配资源
     *      第三代线程安全集合类
     *          在大量并发情况下如何提高集合的效率与安全呢？
     *          java.util.concurrent.*
     *          ConcurrentHashMap
     *          CopyOnWriteArrayList
     *          CopyOnWriteArraySet, 注意：不是 CopyOnWriteHashSet
     *          底层大都采用Lock锁，（1.8的ConcurrentHashMap 不使用 Lock 锁），保证安全的同时，性能也很高。
     */



    public static void main(String[] args) {
    }
}

class CcccExecption extends Exception {

}
