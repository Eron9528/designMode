package cn.bingfa.guardedsuspension;

public class ClientThread extends Thread {
    private RequestQueue requestQueue;    // 请求队列
    public ClientThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue = requestQueue;
    }

    public void run(){
        for (int i= 0; i <10; i++){
            Request request = new Request("RequestID:" + i + " Thread_Name:" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.addRequest(request);    // 提交请求
            try {
                Thread.sleep(100);         // 客户端请求的速度
                                                // 快于服务端处理的速度
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is:" + Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + " requests end");
    }
}
