package cn.a_designmode.proxy.staticproxy;

public class Main {
    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy();
        for (int i = 0; i<10;i++){
            Thread thread = new Thread(()->{
                System.out.println(1);
                q.request();
            });
            thread.run();
        }
    }
}
