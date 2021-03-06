package cn.com.bate5.javasebasic.g_multithreading.c_multithreadquestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Question1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread thread1 = new MyThread();
//        Thread thread2 = new MyThread();
//        Thread thread3 = new Thread(new MyThread2());
//        Thread thread4 = new Thread(new MyThread2());
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();

        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i<taskSize; i++){
            Callable c = new MyCallable(i+" ");
            // 执行任务并获取Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list){
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime()-date1.getTime())+"毫秒】");
    }


}

class MyThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName()+" : myThread.run()");
    }

}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" : myThread2.run()");
    }
}


// 有返回值的线程
class MyCallable implements Callable<Object> {
    private String taskNum;

    public MyCallable(String taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}
