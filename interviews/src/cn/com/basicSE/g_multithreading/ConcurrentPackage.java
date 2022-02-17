package cn.com.basicSE.g_multithreading;

public class ConcurrentPackage {

    /**
     *    ( 1 ) Java的线程并发库介绍
     *    Java5的多线程并有两个大发库在java.util.concurrent包及子包中，子包主要的包有一下两个
     *       1) java.util.concurrent包 (多线程并发库)
     *          ➢ java.util.concurrent 包含许多线程安全、测试良好、高性能的并发构建块。不客气地说，创建 java.util.concurrent 的目的
     *             就是要实现 Collection 框架对数据结构所执行的并发操作。通过提供一组可靠的、高性能并发构建块，开发人员可以提高并发类的线程
     *             安全、可伸缩性、性能、可读性和可靠性，后面、我们会做介绍。
     *          ➢ 如果一些类名看起来相似，可能是因为 java.util.concurrent 中的许多概念源自 Doug Lea 的 util.concurrent 库。
     *       2) java.util.concurrent.atomic包 (多线程的原子性操作提供的工具类)
     *          ➢ 查看atomic包文档页下面的介绍，它可以对多线程的基本数据、数组中的基本数据和对象中的基本数据进行多线程的操作
     *            （AtomicInteger、AtomicIntegerArray、AtomicIntegerFieldUpDater…）
     *          ➢ 通过如下两个方法快速理解atomic包的意义：
     *              AtomicInteger类的boolean compareAndSet(expectedValue, updateValue);
     *              AtomicIntegerArray类的int addAndGet(int i, int delta);
     *          ➢ 顺带解释volatile类型的作用，需要查看java语言规范。
     *              volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。（具有可见性）
     *              volatile没有原子性。
     *       3) java.util.concurrent.lock包 (多线程的锁机制)
     *             为锁和等待条件提供一个框架的接口和类，它不同于内置同步和监视器。该框架允许更灵活地使用锁和条件。本包下有三大接口，下面简单介绍下：
     *          ➢ Lock 接口：支持那些语义不同（重入、公平等）的锁规则，可以在非阻塞式结构的上下文（包括 handover-hand 和锁重排算法）中使用
     *             这些规则。主要的实现是 ReentrantLock。
     *          ➢ ReadWriteLock 接口：以类似方式定义了一些读取者可以共享而写入者独占的锁。此包只提供了一个实现，即 ReentrantReadWriteLock，
     *             因为它适用于大部分的标准用法上下文。但程序员可以创建自己的、适用非标准要求的实现。
     *          ➢ Condition 接口：描述了可能会与锁有关联的条件变量。这些变量在用法上与使用 Object.wait 访问的隐式监视器类似，但提供了
     *             更强大的功能。需要特别指出的是，单个 Lock 可能与多个 Condition 对象关联。为了避免兼容性问题，Condition 方法的名称
     *             与对应的 Object 版本中的不同。
     *
     *     ( 2 ) Java的并发库入门
     *       1) java.util.concurrent包
     *          java.util.concurrent包描述：
     *          在并发编程中很常用的实用工具类。此包包括了几个小的、已标准化的可扩展框架，以及一些提供有用功能的类。此包下有一些组件，其中包括：
     *           执行程序（线程池）
     *           并发队列
     *           同步器
     *           并发Collocation
     *          下面我们将java.util.concurrent包下的组件逐一简单介绍：
     *          A. 执行程序
     *              ➢ Executors线程池工厂类
     *                  首次我们来说下线程池的作用:
     *                         线程池作用就是限制系统中执行线程的数量。
     *                         根据系统的环境情况，可以自动或手动设置线程数量，达到运行的最佳效果；少了浪费了系统资源，多了
     *                      造成系统拥挤效率不高。用线程池控制线程数量，其他线程 排队等候。一个任务执行完毕，再从队列的中取
     *                      最前面的任务开始执行。若队列中没有等待进程，线程池的这一资源处于等待。当一个新任务需要运行时，如
     *                      果线程 池中有等待的工作线程，就可以开始运行了；否则进入等待队列。
     *                  为什么要用线程池:
     *                       减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务
     *                       可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为因为消耗过多的内存，而把服务
     *                        器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机
     *
     *
     *
     */

}
