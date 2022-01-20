package cn.bingfa.guardedsuspension;

import cn.bingfa.futuremode.FutureData;
import cn.bingfa.futuremode.RealData;

public class ServerThread extends Thread {
    private RequestQueue requestQueue;    // 请求队列

    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    public void run() {
        while (true) {
            final Request request = requestQueue.getRequest();   // 得到请求
            final FutureData future = (FutureData) request.getResponse();
            // RealData 的创建比较耗时
            RealData realData = new RealData(request.getName());
            // 处理完成后通知客户进程
       //     future

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " handles" + request);
        }
    }

}
