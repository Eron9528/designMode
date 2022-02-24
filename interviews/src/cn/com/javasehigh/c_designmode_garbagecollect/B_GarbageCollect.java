package cn.com.javasehigh.c_designmode_garbagecollect;

public class B_GarbageCollect {

    // 9. JVM垃圾回收机制和常见算法
    /**
     *     理论上来讲Sun公司只定义了垃圾回收机制规则而不局限于其实现算法，因此不同厂商生产的虚拟机采用的算法也不尽相同。
     *     GC（Garbage Collector）在回收对象前首先必须发现那些无用的对象，如何去发现定位这些无用的对象？常用的搜索算法如下：
     *     1）引用计数器算法（废弃）
     *          引用计数器算法是给每个对象设置一个计数器，当有地方引用这个对象的时候，计数器+1，当引用失效的时候，
     *       计数器-1，当计数器为0的时候，JVM就认为对象不再被使用，是“垃圾”了。
     *          引用计数器实现简单，效率高；但是不能解决循环引用问问题（A对象引用B对象，B对象又引用A对象，但是
     *       A,B对象已不被任何其他对象引用），同时每次计数器的增加和减少都带来了很多额外的开销，所以在JDK1.1之后，
     *       这个算法已经不再使用了。
     *     2）根搜索算法（使用）
     *          根搜索算法是通过一些“GC Roots”对象作为起点，从这些节点开始往下搜索，搜索通过的路径成为引用链
     *       （Reference Chain），当一个对象没有被GC Roots的引用链连接的时候，说明这个对象是不可用的。
     *          GC Roots对象包括：
     *              a) 虚拟机栈（栈帧中的本地变量表）中的引用的对象。
     *              b) 方法区域中的类静态属性引用的对象。
     *              c) 方法区域中常量引用的对象。
     *              d) 本地方法栈中JNI（Native方法）的引用的对象。
     *
     *              通过上面的算法搜索到无用对象之后，就是回收过程，回收算法如下：
     *                  1）标记—清除算法（Mark-Sweep）（DVM使用的算法）
     *                         标记—清除算法包括两个阶段：“标记”和“清除”。在标记阶段，确定所有要回收的对象，并做标记。清除阶段
     *                      紧随标记阶段，将标记阶段确定不可用的对象清除。标记—清除算法是基础的收集算法，标记和清除阶段的效率不高，
     *                      而且清除后回产生大量的不连续空间，这样当程序需要分配大内存对象时，可能无法找到足够的连续空间。
     *                  2）复制算法（Copying）
     *                         复制算法是把内存分成大小相等的两块，每次使用其中一块，当垃圾回收的时候，把存活的对象复制到另一块上，
     *                      然后把这块内存整个清理掉。复制算法实现简单，运行效率高，但是由于每次只能使用其中的一半，造成内存的利用率
     *                      不高。现在的JVM用复制方法收集新生代，由于新生代中大部分对象（98%）都是朝生夕死的，所以两块内存的比例
     *                      不是1:1(大概是8:1)。
     *                  3）标记—整理算法（Mark-Compact）
     *                          标记—整理算法和标记—清除算法一样，但是标记—整理算法不是把存活对象复制到另一块内存，而是把存活对
     *                      象往内存的一端移动，然后直接回收边界以外的内存。标记—整理算法提高了内存的利用率，并且它适合在收集对象
     *                      存活时间较长的老年代。
     *                  4）分代收集（Generational Collection）
     *                          分代收集是根据对象的存活时间把内存分为新生代和老年代，根据各个代对象的存活特点，每个代采用不同的垃
     *                      圾回收算法。新生代采用复制算法，老年代采用标记—整理算法。垃圾算法的实现涉及大量的程序细节，而且不同的
     *                      虚拟机平台实现的方法也各不相同。
     *
     *
     */


    // 10. 谈谈JVM的内存结构和内存分配
    /**
     *      Java虚拟机将其管辖的内存大致分三个逻辑部分：方法区(Method Area)、Java栈和Java堆
     *
     *    a) Java内存模型
     *      1、方法区是静态分配的，编译器将变量绑定在某个存储位置上，而且这些绑定不会在运行时改变。
     *          常数池，源代码中的命名常量、String常量和static变量保存在方法区。
     *      2、Java Stack是一个逻辑概念，特点是后进先出。一个栈的空间可能是连续的，也可能是不连续的。
     *          最典型的Stack应用是方法的调用，Java虚拟机每调用一次方法就创建一个方法帧（frame），退出该
     *          方法则对应的 方法帧被弹出(pop)。栈中存储的数据也是运行时确定的。
     *      3、Java堆分配(heap allocation)意味着以随意的顺序，在运行时进行存储空间分配和收回的内存管理模型。
     *          堆中存储的数据常常是大小、数量和生命期在编译时无法确定的。Java对象的内存总是在heap中分配。
     *          我们每天都在写代码，每天都在使用JVM的内存。
     *    b) java内存分配
     *      1、基础数据类型直接在栈空间分配;
     *      2、方法的形式参数，直接在栈空间分配，当方法调用完成后从栈空间回收;
     *      3、引用数据类型，需要用new来创建，既在栈空间分配一个地址空间，又在堆空间分配对象的类变量;
     *      4、方法的引用参数，在栈空间分配一个地址空间，并指向堆空间的对象区，当方法调用完后从栈空间回收;
     *      5、局部变量 new 出来时，在栈空间和堆空间中分配空间，当局部变量生命周期结束后，栈空间立刻被回收，堆空间区域等待GC回收;
     *      6、方法调用时传入的实际参数，先在栈空间分配，在方法调用完成后从栈空间释放;
     *      7、字符串常量在 DATA 区域分配 ，this 在堆空间分配;
     *      8、数组既在栈空间分配数组名称， 又在堆空间分配数组实际的大小！
     *
     */


}

















