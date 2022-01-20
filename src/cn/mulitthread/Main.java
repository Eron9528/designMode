package cn.mulitthread;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++){
//            new Thread(new MyThread("testNoThreadPool" + Integer.toString(i))).start();
//        }
        System.out.println(System.currentTimeMillis()-start);
        for (int i = 0; i< 100000; i++){
            ThreadPool.getInstance().start(new MyThread("testNoThreadPool" + Integer.toString(i)));
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
