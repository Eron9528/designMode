package cn.com.basicSE.g_multithreading.c_multithreadquestion;

public class Question13_MySingle {
    // 共享的变量
    private boolean hasDataToProcess = false;
    // 取值
    public boolean getHasDataToProcess() {
        return hasDataToProcess;
    }
    // 存值
    public void setHasDataToProcess(boolean hasDataToProcess){
        this.hasDataToProcess = hasDataToProcess;
    }

    public static void main(String[] args) {
        // 同一个对象
        final Question13_MySingle mySingle = new Question13_MySingle();
        // 线程设置 hasDataToProcess 值为true
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mySingle.hasDataToProcess = true;
            }
        });
        thread1.start();
        // 线程2 取这个值 hasDataToProcess
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    // 等待线程执行完毕后取值
                    thread1.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                mySingle.getHasDataToProcess();
                System.out.println("t1 改变以后的值：" + mySingle.getHasDataToProcess());
            }
        });
        thread2.start();
    }

}
