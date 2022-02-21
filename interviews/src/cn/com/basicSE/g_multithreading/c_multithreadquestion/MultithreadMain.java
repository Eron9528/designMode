package cn.com.basicSE.g_multithreading.c_multithreadquestion;

import java.util.concurrent.Executors;

public class MultithreadMain {

    /**
     *
     *
     */

    public static void main(String[] args) {

        // 1. 多线程的创建方式
        /**
         *  （1）、继承Thread类：
         *      但Thread本质上也是实现了Runnable接口的一个实例，它代表一个线程的实例，并且，
         *      启动线程的唯一方法就是通过Thread类的start()实例方法。start()方法是一个native方法，它将启动一个新线
         *      程，并执行run()方法。这种方式实现多线程很简单，通过自己的类直接extend Thread，并复写run()方法，就可以
         *      启动新线程并执行自己定义的run()方法。例如：继承Thread类实现多线程，并在合适的地方启动线程.
         *  （2）、实现Runnable接口的方式实现多线程，并且实例化Thread，传入自己的Thread实例，调用run( )方法
         *  （3）、使用ExecutorService、Callable、Future实现有返回结果的多线程：ExecutorService、Callable、Future
         *      这个对象实际上都是属于Executor框架中的功能类。返回结果的线程是在JDK1.5中引入
         *      的新特征，确实很实用，有了这种特征我就不需要再为了得到返回值而大费周折了，而且即便实现了也可能漏洞百出。
         *      可返回值的任务必须实现Callable接口，类似的，无返回值的任务必须Runnable接口。执行Callable任务后，可以
         *      获取一个Future的对象，在该对象上调用get就可以获取到Callable任务返回的Object了，再结合线程池接口
         *      ExecutorService就可以实现传说中有返回结果的多线程了。
         *
         */

        // 2. 在java 中 wait 和 sleep 方法的不同？
        /**
         *      最大的不同是wait 会释放锁，而 sleep 一直持有锁。 wait 通常被用于线程间的交互，sleep 通常被用于暂停执行
         */

        // 3. synchronized和volatile关键字的作用
        /**
         *      一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
         *      1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
         *      2）禁止进行指令重排序。
         *          volatile本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取；
         *          synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住。
         *          1. volatile仅能使用在变量级别；
         *             synchronized则可以使用在变量、方法、和类级别的
         *          2. volatile仅能实现变量的修改可见性，并不能保证原子性；
         *             synchronized则可以保证变量的修改可见性和原子性
         *          3. volatile不会造成线程的阻塞；
         *             synchronized可能会造成线程的阻塞。
         *          4. volatile标记的变量不会被编译器优化；
         *             synchronized标记的变量可以被编译器优化
         *
         *
         */


         // 4. 分析线程并发访问代码解释原因

         // 5. 什么是线程池，如何使用？
         /**
          *     线程池就是事先将多个线程对象放到一个容器中，当使用的时候就不用new线程而是直接去池中拿线程即可，节
          *     省了开辟子线程的时间，提高的代码执行效率。
          *     在JDK的java.util.concurrent.Executors中提供了生成多种线程池的静态方法。
          *     然后调用他们的execute方法即可。
          */

         // 6. 常用的线程池有哪些？
        /**
         *    newSingleThreadExecutor：创建一个单线程的线程池，此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
         *    newFixedThreadPool：创建固定大小的线程池，每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
         *    newCachedThreadPool：创建一个可缓存的线程池，此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统
         *                          （或者说JVM）能够创建的最大线程大小。
         *    newScheduledThreadPool：创建一个大小无限的线程池，此线程池支持定时以及周期性执行任务的需求。
         *    newSingleThreadScheduledExecutor：创建一个单线程的线程池。此线程池支持定时以及周期性执行任务的需求。
         */

        // 7. 请叙述一下您对线程池的理解？
        /**
         *   （如果问到了这样的问题，可以展开的说一下线程池如何用、线程池的好处、线程池的启动策略）
         *   合理利用线程池能够带来三个好处。
         *      第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
         *      第二：提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
         *      第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，
         *          使用线程池可以进行统一的分配，调优和监控。
         */

        // 8. 线程池的启动策略？
        /**
         *
         */





    }

}
