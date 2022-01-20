package cn.a_designmode.proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDbQueryInterceptor implements MethodInterceptor {
    IDBQuery3 real = null;

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null){
            real = new DBQuery3();
        }
        return real.request();
    }

    public static IDBQuery3 createCglibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor());    // 指定切入器，定义代理类逻辑
        enhancer.setInterfaces(new Class[]{IDBQuery3.class});   // 指定实现的接口
        IDBQuery3 cglibProxy = (IDBQuery3)enhancer.create();    // 生成代理类的实例
        return cglibProxy;
    }
}
