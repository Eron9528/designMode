package cn.a_designmode.proxy.jdkdynamicproxy;

public class DBQuery2 implements IDBQuery2 {
    public DBQuery2(){
        try {
            Thread.sleep(1000);
            System.out.println("thre");// 模拟数据库连接等耗时的操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String request() {
        return "request string";
    }
}
