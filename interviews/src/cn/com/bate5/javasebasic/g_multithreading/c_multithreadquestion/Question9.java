package cn.com.bate5.javasebasic.g_multithreading.c_multithreadquestion;

import java.util.concurrent.Semaphore;

public class Question9 {

    static Semaphore semaphore = new Semaphore(5);
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }).start();
        }
    }

    public static void test(){
        try{
            // 申请一个请求
            semaphore.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "进来了");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "走了");
        semaphore.release();
    }
}
