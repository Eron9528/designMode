package cn.com.java.cuncurrent.lesson1seeableautomticshunxu;

public class SeeableTest {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        System.out.println(test.calc());

    }
}

class Test{
    private static volatile long count = 0;
    private void add10K(){
        int idx = 0;
        while (idx++ < 10000){
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Test test = new Test();
        Thread thread1 = new Thread(()-> test.add10K());
        Thread thread2 = new Thread(()-> test.add10K());
        thread1.start();
        thread2.start();
        // 等待两个线程结束
        thread1.join();
        thread1.join();
        return count;
    }
}
