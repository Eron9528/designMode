package cn.a_java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\Maero\\Desktop\\新建文本文档 (5).txt")));
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        return wordList.stream();
    }

    public static <T> void show(String lable, Set<T> set){
        System.out.println(lable + ":" + set.getClass().getName());
        System.out.println("[" + set.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");

    }


    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n+1).limit(10).iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        Object[] numbers = Stream.iterate(0, n -> n+1).limit(10).toArray();
        System.out.println("Object array:" + numbers);     // Note it's an Object[] array

        Integer number = (Integer) numbers[0];

        Integer[] numbers3 = Stream.iterate(0, n -> n+1).limit(10).toArray(Integer[]::new);
        System.out.println("Object array:" + numbers3);     // Note it's an Object[] array

        Integer[] number2 = (Integer[]) numbers3;

        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());

        show("noVowelSet", noVowelSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println(result);

        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);

        System.out.println("foreach: ");
        noVowels().limit(10).forEach(System.out::println);

    }
}
