package cn.b_component_method.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.Serializable;

public class EHCacheUtil {

    private static final CacheManager manager;

    static{
        manager = CacheManager.create();
        EHCacheUtil.class.getClassLoader().getResourceAsStream("../ehcache.xml");
    }

    public static void put(String cachename, Serializable key, Serializable value){
        manager.getCache(cachename).put(new Element(key,value));
    }

    public static Serializable get(String cachename, Serializable key){
        Element e = manager.getCache(cachename).get(key);
        if (e == null) return null;
        return e.getValue();
    }


}
