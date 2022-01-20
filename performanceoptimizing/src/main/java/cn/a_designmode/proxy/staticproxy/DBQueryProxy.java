package cn.a_designmode.proxy.staticproxy;

public class DBQueryProxy implements IDBQuery{
    private IDBQuery real = null;
    @Override
    public String request() {
        if (real == null){
            real = new DBQuery();
        }
        return real.request();
    }
}
