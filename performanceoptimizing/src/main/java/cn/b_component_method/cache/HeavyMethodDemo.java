package cn.b_component_method.cache;

import net.sf.cglib.proxy.Enhancer;

public class HeavyMethodDemo {
    public String heavyMethod(int num){
        StringBuffer sb = new StringBuffer();
        // 对 num 进行因式分解，将结果保存在 sb 中。
        return sb.toString();
    }

    public static HeavyMethodDemo newCacheHeavyMethod(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HeavyMethodDemo.class);
        enhancer.setCallback(new CglibHeavyMethodInterceptor());
        HeavyMethodDemo cglibProxy = (HeavyMethodDemo) enhancer.create();
        return cglibProxy;
    }

    public static HeavyMethodDemo newHeavyMethod(){
        return new HeavyMethodDemo();
    }


}
