package cn.a_java8;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStreams {

    public static void main(String[] args) {

        // 产生一个给定元素的流
        Stream<String> song = Stream.of("sss", "sssss");

        Stream<String> silence = Stream.empty();

        Stream<String> echos = Stream.generate(() -> "echo");

        // concat 可以连接两个流
        Stream<String> newLLi = Stream.concat(silence,echos);
   //     show("echos", echos);

        // 获取一个随机数流
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
   //     show("randoms", randoms);
        // 获取无限序列
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        // 静态的 Files.lines 方法会返回一个包含了文件中所有行的 Stream:
        try {
            Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Maero\\Desktop\\新建文本文档 (2).txt"));
       //     show("line",lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // distinct 去除重复
        Stream<String> distinct = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        Stream<String> sorted = distinct.sorted(Comparator.comparing(String::length).reversed());

        // peek 可以把每个流元素带到执行的方法里面
        Object[] powers = Stream.iterate(1.0, p -> p*2).peek(e -> System.out.println(e)).limit(2).toArray();

        // 获取流的最大值
        Optional<String> max = Stream.of("2","3").max(String::compareToIgnoreCase);
        System.out.println("max:" + max.orElse(""));

        List<String> results = new ArrayList<>();
        Optional<String> optionalString = Stream.of("111","122").findAny();
        optionalString.ifPresent(results::add);
        Optional<Boolean> aBoolean = optionalString.map(results::add);
        // 如何使用 Optional 值
        String result = optionalString.orElseGet(()->Locale.getDefault().getDisplayName());
        System.out.println(Locale.getDefault().getDisplayName());

        Optional.ofNullable(1);
    }

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.println(title + "：");
        for (int i=0; i<firstElements.size(); i++){
            if (i > 0){
                System.out.println(", ");
            }
            if (i < SIZE){
                System.out.println(firstElements.get(i));
            }else{
                System.out.println("...");
            }
        }

    }

    public static Optional<Double> inverse(double x){
        return x == 0 ? Optional.empty() : Optional.of(1/x);
    }

}
