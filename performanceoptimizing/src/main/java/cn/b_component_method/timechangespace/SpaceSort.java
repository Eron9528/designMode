package cn.b_component_method.timechangespace;

import java.util.HashMap;
import java.util.Map;

public class SpaceSort {
    public static int arrayLen = 1000000;

    public static void main(String[] args) {
        int[] a = new int[arrayLen];
        int[] old = new int[arrayLen];
        Map<Integer,Object> map = new HashMap<>();
        int count = 0;
        while (count< a.length){
            int value = (int) ((Math.random()*arrayLen*10)+1);
            if (map.get(value) == null){
                map.put(value, value);
                a[count] = value;
                count++;
            }
        }
        System.arraycopy(a, 0, old,0, a.length);
    }
}
