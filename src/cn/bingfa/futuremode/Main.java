package cn.bingfa.futuremode;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
//        Client client = new Client();
//        Data data = client.request("name");
//        System.out.println("数据="+data.getResult());
//        System.out.println("请求完毕");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("数据="+data.getResult());

        System.out.println("1");
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("2"));
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        executor.submit(futureTask);
        futureTask.run();
        System.out.println("3");
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
