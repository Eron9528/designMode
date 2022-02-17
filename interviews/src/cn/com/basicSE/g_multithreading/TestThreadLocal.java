package cn.com.basicSE.g_multithreading;

import java.util.Random;

public class ThreadLocalTest implements Runnable{

    ThreadLocal<Studen> studenThreadLocal = new ThreadLocal<Studen>();

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is Running ... ");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println(currentThreadName + " is set age : "+ age);
        Studen studen = getStudent();
        studen.setAge(age);
        System.out.println(currentThreadName + " is first get age: " + studen.getAge());

    }

    private Studen getStudent(){
        Studen studen = studenThreadLocal.get();
        if (null == studen){
            studen = new Studen();
            studenThreadLocal.set(studen);
        }
        return studen;
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        new Thread(test,"Thread A").start();
        new Thread(test,"Thread B").start();
    }

}

class Studen {
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}