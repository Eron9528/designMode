package cn.a_designmode.proxy.cglibdynamicproxy;


public class Main {
    public static void main(String[] args) {
        IDBQuery3 idbQuery = (IDBQuery3)CglibDbQueryInterceptor.createCglibProxy();

        for (int i = 0;i<10;i ++){
            Thread thread = new Thread(()->{
                idbQuery.request();
                System.out.println("1");
            });
            thread.run();
        }
    }
}
