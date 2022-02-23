package cn.com.javasebasic.g_multithreading.c_multithreadquestion;

import java.util.concurrent.Semaphore;

public class Question10 {

    private static Semaphore semaphore = new Semaphore(0);
    private static int num; // 定义一个变量作为数据

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    num++;
                    semaphore.release(2);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    semaphore.acquire();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "获取到 num 的值为"+num);
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    semaphore.acquire();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "获取到num 的值为"+ num);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
