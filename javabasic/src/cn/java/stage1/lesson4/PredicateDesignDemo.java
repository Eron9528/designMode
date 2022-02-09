package cn.java.stage1.lesson4;

import java.util.*;
import java.util.function.Predicate;

public class PredicateDesignDemo {
    public static void main(String[] args) {

        List<String> strs = new ArrayList<>();
        strs.add("1");
        strs.add("2");
        Collection<String> two =  filter(strs, s ->  {
                if (s.equals("1"))
                return false;
                return true;
        });
        System.out.println(two.size());
    }

    public static <E> Collection<E> filter(Collection<E> source, Predicate<E> p){
        // 集合类操作，请不要直接利用参数
        List<E> copy = new ArrayList<>(source);
        Iterator<E> iterator = copy.iterator();
        while (iterator.hasNext()){
            E element = iterator.next();
            if (!p.test(element)){
                copy.remove(element);
            }
        }
        return Collections.unmodifiableCollection(copy);
    }
}
