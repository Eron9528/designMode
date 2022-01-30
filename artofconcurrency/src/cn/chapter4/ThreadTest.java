package cn.chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadTest {
    /**
     *   1. 线程---》 轻量级进程
     *   2. 线程各自拥有各自的计数器、堆栈、和局部变量等属性，并且能够访问共享的内存变量。
     */

    public static void main(String[] args) {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (int i = 0; i<threadInfos.length;i++){
            System.out.println(threadInfos[i].getThreadId()+"----"+threadInfos[i].getThreadName());
        }
    }

    /**
     *
     *  1. 为什么使用多线程
     *          更多的处理核心
     *          更快的响应时间
     *          更好的编程模型
     *
     *  2. 线程的优先级
     *          分时的形式调度运行线程。
     *          priority  1-10， 默认是5
     *
     * */
}
