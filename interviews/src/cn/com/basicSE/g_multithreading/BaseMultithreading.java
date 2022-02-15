package cn.com.basicSE.g_multithreading;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class BaseMultithreading {

    public static void main(String[] args) {

        // (1). 传统使用类Thread和接口Runnable实现
        /**
         *  1. 传统使用类Thread和接口Runnable实现
         */

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        /**
         *   2. 在传递给Thread对象的Runnable对象的run方法中编写代码
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
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
        Timer timer = new Timer();
        timer.schedule(new TimerTastCus(),2000 + 2000 * count);

        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


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
         */




    }

    static class TimerTastCus extends TimerTask {
        @Override
        public void run() {
            count = (count + 1) % 2;
            System.err.println("Boom boom");
            new Timer().schedule(new TimerTastCus(), 2000+2000*count);
        }
    }
    private static volatile int count = 0;
}
