package cn.com.basicSE.g_multithreading;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class BaseMultithreading {

    public static void main(String[] args) {

        // (1). 传统使用类Thread和接口Runnable实现
        /**
         *  1. 传统使用类Thread和接口Runnable实现
         */
        System.out.println("=============题目1===============");

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName());
//            }
//        }.start();
        /**
         *   2. 在传递给Thread对象的Runnable对象的run方法中编写代码
         */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName());
//            }
//        }).start();
        /**
         *  3. 总结
         *      查看Thread类的run()方法的源代码，可以看到其实这两种方式都是在调用Thread对象的run方法，如果Thread类的run方法没有被覆盖，
         *      并且为该Thread对象设置了一个Runnable对象，该run方法会调用Runnable对象的run方法
         */


        // (2). 定实现时器Timer和TimerTask
        /**
         *      Timer在实际开发中应用场景不多，一般来说都会用其他第三方库来实现。但有时会在一些面试题中出现。
         *      下面我们就针对一道面试题来使用Timer定时类。
         *       请模拟写出双重定时器（面试题）
         *       要求：使用定时器,间隔4秒执行一次，再间隔2秒执行一次，以此类推执行。
         */

        System.out.println("=============题目2===============");

//        Timer timer = new Timer();
//        timer.schedule(new TimerTastCus(),2000 + 2000 * count);
//
//        while (true){
//            System.out.println(new Date().getSeconds());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


        // (3) 线程互斥与同步
        /**
         *   在引入多线程后，由于线程执行的异步性，会给系统造成混乱，特别是在急用临界资源时，如多个线程急用同一台打印机，会使打印结果交织在一起，
         *   难于区分。当多个线程急用共享变量，表格，链表时，可能会导致数据处理出错，因此线程同步的主要任务是使并发执行的各线程之间能够有效的
         *   共享资源和相互合作，从而使程序的执行具有可再现性。
         *   当线程并发执行时，由于资源共享和线程协作，使用线程之间会存在以下两种制约关系。
         *   1. 间接相互制约。一个系统中的多个线程必然要共享某种系统资源，如共享CPU，共享I/O设备，所谓间接相互制约即源于这种资源共享，打印机
         *   就是最好的例子，线程A在使用打印机时，其它线程都要等待。
         *   2. 直接相互制约。这种制约主要是因为线程之间的合作，如有线程A将计算结果提供给线程B作进一步处理，那么线程B在线程A将数据送达之前都
         *   将处于阻塞状态。
         *   间接相互制约可以称为互斥，直接相互制约可以称为同步，对于互斥可以这样理解，线程A和线程B互斥访问某个资源则它们之间就会产个顺序问题
         *   ——要么线程A等待线程B操作完毕，要么线程B等待线程操作完毕，这其实就是线程的同步了。因此同步包括互斥，互斥其实是一种特殊的同步。
         *
         *   面试题：
         *      要求：子线程运行执行10次后，主线程再运行5次。这样交替执行三遍
         */
        System.out.println("=============题目3===============");
//        Thread mainThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("------主线程运行-------");
//            }
//        });
//        Thread subThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("-----子线程运行--------");
//            }
//        });
//        int count = 0;
//        for (int a = 0; a < 3; a++){
//            for (int i = 0;i<10;i++){
//                subThread.run();
//            }
//            for (int j=0;j<5;j++){
//                mainThread.run();
//            }
//        }




//        final Bussiness bussiness = new Bussiness();
//        // 子线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i<3;i++){
//                    try {
//                        bussiness.subMethod();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        // 主线程
//        for (int i = 0; i<3;i++){
//            try {
//                bussiness.mainMethod();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


        // (4). 线程局部变量ThreadLocal
        /**
         *     ThreadLocal的作用和目的：用于实现线程内的数据共享，即对于相同的程序代码，多个模块在同一个线程中运行时要共享一份数据，
         *      而在另外线程中运行时又共享另外一份数据。
         *     每个线程调用全局ThreadLocal对象的set方法，在set方法中，首先根据当前线程获取当前线程的ThreadLocalMap对象，然后
         *      往这个map中插入一条记录，key其实是ThreadLocal对象，value是各自的set方法传进去的值。也就是每个线程其实都有一份
         *      自己独享的ThreadLocalMap对象，该对象的Key是ThreadLocal对象，值是用户设置的具体值。在线程结束时可以调用
         *      ThreadLocal.remove()方法，这样会更快释放内存，不调用也可以，因为线程结束后也可以自动释放相关的ThreadLocal变量。
         *     ThreadLocal的应用场景：
         *      ➢ 订单处理包含一系列操作：减少库存量、增加一条流水台账、修改总账，这几个操作要在同一个事务中完成，通常也即同一个线程
         *        中进行处理，如果累加公司应收款的操作失败了，则应该把前面的操作回滚，否则，提交所有操作，这要求这些操作使用相同的
         *        数据库连接对象，而这些操作的代码分别位于不同的模块类中。
         *      ➢ 银行转账包含一系列操作： 把转出帐户的余额减少，把转入帐户的余额增加，这两个操作要在同一个事务中完成，它们必须使用
         *        相同的数据库连接对象，转入和转出操作的代码分别是两个不同的帐户对象的方法。
         *      ➢ 例如Strut2的ActionContext，同一段代码被不同的线程调用运行时，该代码操作的数据是每个线程各自的状态和数据，对于
         *        不同的线程来说，getContext方法拿到的对象都不相同，对同一个线程来说，不管调用getContext方法多少次和在哪个模块
         *        中getContext方法，拿到的都是同一个。
         *
         *        1. ThreadLocal的使用方式
         *          (1) 在关联数据类中创建private static ThreadLocal
         *                 在下面的类中，私有静态 ThreadLocal 实例（serialNum）为调用该类的静态 SerialNum.get() 方法的每个线程
         *              维护了一个“序列号”，该方法将返回当前线程的序列号。（线程的序列号是在第一次调用SerialNum.get() 时分配的，
         *              并在后续调用中不会更改。）
         *              另一个例子，也是私有静态 ThreadLocal 实例：
         *          (2) 在Util类中创建ThreadLocal
         *              把ThreadLocal的创建放到工具类中。
         *          (3) 在Runnable中创建ThreadLocal
         *              在线程类内部创建ThreadLocal，基本步骤如下：
         *              ①、在多线程的类（如ThreadDemo类）中，创建一个ThreadLocal对象threadXxx，用来保存线程间需要隔离处理的对象xxx。
         *              ②、在ThreadDemo类中，创建一个获取要隔离访问的数据的方法getXxx()，在方法中判断，若ThreadLocal对象为null时候，
         *                  应该new()一个隔离访问类型的对象，并强制转换为要应用的类型
         *              ③、在ThreadDemo类的run()方法中，通过调用getXxx()方法获取要操作的数据，这样可以保证每个线程对应一个数据对象，
         *                  在任何时刻都操作的是这个对象。
         *
         */

        // ( 5 ) 多线程共享数据
        /**
         *      在Java传统线程机制中的共享数据方式，大致可以简单分两种情况：
         *      ➢ 多个线程行为一致，共同操作一个数据源。也就是每个线程执行的代码相同，可以使用同一个Runnable对象，这个Runnable对象中
         *          有那个共享数据，例如，卖票系统就可以这么做。
         *      ➢ 多个线程行为不一致，共同操作一个数据源。也就是每个线程执行的代码不同，这时候需要用不同的Runnable对象。例如，银行存取款。
         *      下面我们通过两个示例代码来分别说明这两种方式。
         */

        /**
         *      1. 多个线程行为一致共同操作一个数据
         *      如果每个线程执行的代码相同，可以使用同一个Runnable对象，这个Runnable对象中有那个共享数据，例如，买票系统就可以这么做。
         */
        System.out.println("=============题目4===============");

        ShareData shareData = new ShareData();
        for (int i = 0; i<4;i++){
            new Thread(new RunnableCusToInc(shareData), "Thread" + i).start();
        }

        /**
         *      2. 多个线程行为不一致共同操作一个数据
         *      如果每个线程执行的代码不同，这时候需要用不同的Runnable对象，有如下两种方式来实现这些Runnable对象之间的数据共享：
         *      例：TwoThreadShareOneDataTest.java
         *
         */


    }
}


/**
 * 共享数据类
 */
class ShareData{
    private int num = 0;
    public synchronized void inc(){
        num ++;
        System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 多线程类
 */
class RunnableCusToInc implements Runnable{

    private ShareData shareData;
    public RunnableCusToInc(ShareData shareData){
        this.shareData = shareData;
    }
    @Override
    public void run() {
        for (int i = 0; i<5; i++){
            shareData.inc();
        }

    }
}

class SerialNum {
    // The next serial number to be assigned
    private static int nextSerialNum = 0;
    private static ThreadLocal serialNum = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new Integer(nextSerialNum++);
        }
    };

    public static int get(){
        return ((Integer) (serialNum.get())).intValue();
    }

}

class ThreadContext{
    private String userId;
    private String transactionId;

    private static ThreadLocal threadLocal = new ThreadLocal(){
        @Override
        protected ThreadContext initialValue(){
            return new ThreadContext();
        }
    };

    public static ThreadContext get() {
        return (ThreadContext) threadLocal.get();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}


//
class TimerTastCus extends TimerTask {
    private static volatile int count = 0;
    @Override
    public void run() {
        count = (count + 1) % 2;
        System.err.println("Boom boom");
        new Timer().schedule(new TimerTastCus(), 2000+2000*count);
    }
}

class Bussiness{

    private boolean subFlag = true;

    public synchronized void mainMethod() throws InterruptedException{
        while (subFlag){
            wait();
        }

        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() +
                    " : main thread running loop count -- " + i);
            Thread.sleep(1000);
        }

        subFlag = true;
        notify();
    }

    public synchronized void subMethod() throws InterruptedException{
        while (!subFlag){
            wait();
        }
        for (int i =0; i<10; i++){
            System.err.println(Thread.currentThread().getName()+
                    " : sub thread running loop count -- " + i);
            Thread.sleep(1000);
        }
        subFlag = false;
        notify();
    }
}












