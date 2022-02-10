package cn.a_designmode.proxy.staticproxy;

public class DBQuery implements IDBQuery{
    public DBQuery(){
        try {
            Thread.sleep(10000);
            System.out.println("thre");// 模拟数据库连接等耗时的操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String request() {
        System.out.println("request string");
        return "request string";
    }
}
