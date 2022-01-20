package cn.b_component_method.cache;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

public class CglibHeavyMethodInterceptor implements MethodInterceptor {

    HeavyMethodDemo real = new HeavyMethodDemo();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String v = (String) EHCacheUtil.get("cache1", (Serializable) objects[0]);
        if (v == null){
            v = real.heavyMethod((Integer) objects[0]);
            EHCacheUtil.put("cache1",(Integer)objects[0],v);
        }
        return v;
    }
}
