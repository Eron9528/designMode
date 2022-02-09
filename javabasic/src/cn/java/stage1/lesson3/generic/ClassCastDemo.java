package cn.java.stage1.lesson3.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassCastDemo {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("A");

        List<Object> list2 = list;

        List<String> list3 = Collections.emptyList();
        List<String> list4 = Arrays.asList("1","3");
        var li = Collections.emptyList();



        Type type = int.class;
        Class type2 = int.class;
    }

    private static void exchange(List a, List b){

    }

}
