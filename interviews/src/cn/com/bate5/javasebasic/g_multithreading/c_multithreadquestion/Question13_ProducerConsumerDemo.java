package cn.com.bate5.javasebasic.g_multithreading.c_multithreadquestion;

public class Question13_ProducerConsumerDemo {

    public static void main(String[] args) {
        Resource res = new Resource();
        Producer producer = new Producer(res);
        Consumer consumer = new Consumer(res);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}

class Resource{
    private String name;
    private int count =1 ;
    private boolean flag = false;
    public synchronized void set(String name){
        // 生产资源
        while (flag){
            try {
                // 线程等待，消费者消费资源
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "---" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        flag = true;
        // 唤醒等待中的消费者
        this.notifyAll();

    }
    public synchronized void out(){
        // 生产资源
        while (!flag){
            try {
                // 线程等待，生产者生产资源
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        flag = false;
        // 唤醒等待中的消费者
        this.notifyAll();

    }
}

class Producer implements Runnable{

    private Resource res;
    Producer(Resource res){this.res = res;}
    // 生产者生产资源
    @Override
    public void run() {
        while (true){
            res.set("商品");
        }
    }
}

class Consumer implements Runnable{
    private Resource res;
    Consumer(Resource res){this.res = res;}
    @Override
    public void run() {
        while (true){
            res.out();
        }
    }
}
