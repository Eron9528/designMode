package cn.a_designmode.proxy.jdkdynamicproxy;

public class Main {
    public static void main(String[] args) {
        JdkDbQueryHandler handler = new JdkDbQueryHandler();
        IDBQuery2 jdkProxy = handler.createJdkProxy();
        for (int i = 0; i <10; i ++){
            Thread thread = new Thread(()->{
                System.out.println("1");
                jdkProxy.request();
            });
            thread.run();
        }

    }
}
