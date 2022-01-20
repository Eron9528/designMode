package cn.a_designmode.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDbQueryHandler implements InvocationHandler {

    private IDBQuery2 real = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            real = new DBQuery2();
        }
        return real.request();
    }

    public static IDBQuery2 createJdkProxy() {
        IDBQuery2 jdkProxy = (IDBQuery2) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{IDBQuery2.class},
                new JdkDbQueryHandler());
        return jdkProxy;

    }
}
