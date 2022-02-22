package cn.com.basicSE.g_multithreading.c_multithreadquestion;

public class Question12_AvoidDeadLock1 {

    public int flag = 1;
    // 静态对象是类的所有对象共享的
    private static Object o1 = new Object(),o2 = new Object();

    public void money(int flag){
        this.flag = flag;
        if (flag ==1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("当前的线程是"+Thread.currentThread().getName()+" flag的值1");
                }
            }
        }
        if (flag ==0){
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("当前的线程是"+Thread.currentThread().getName()+" flag的值0");
                }
            }
        }
    }

    public static void main(String[] args) {

        //1）加锁顺序（线程按照一定的顺序加锁）


        final Question12_AvoidDeadLock1 td1 = new Question12_AvoidDeadLock1();
        final Question12_AvoidDeadLock1 td2 = new Question12_AvoidDeadLock1();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                td1.flag = 1;
                td1.money(1);
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //让t2等待t1执行完
                    t1.join();//核心代码，让t1执行完后t2才会执行
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                td2.flag = 0;
                td1.money(0);
            }
        });
        t2.start();
    }
}
