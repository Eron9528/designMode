package cn.a_java8;

import java.util.stream.IntStream;

public class PrimitiveTypeStreams {
    public static void show(String title, IntStream stream){
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.println(title + ": ");
        for (int i = 0; i < firstElements.length; i++){
            if (i > 0){
                System.out.println(", ");
            }
            if (i < SIZE){
                System.out.println(firstElements[i]);
            }else {
                System.out.println("...");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        IntStream is1 = IntStream.generate(() -> (int)(Math.random() * 100));
        show("is1" , is1);
        IntStream is2 = IntStream.range(5, 10);
        show("is2" , is2);
        IntStream is3 = IntStream.rangeClosed(5, 10);
        show("is3" , is3);
    }
}
