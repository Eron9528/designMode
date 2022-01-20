package cn.a_designmode.proxy.javassistdynamicproxy1;

public class DBQuery4 implements IDBQuery4 {
    public DBQuery4(){
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
