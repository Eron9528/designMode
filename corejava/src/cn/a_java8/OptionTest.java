package cn.a_java8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OptionTest {

    public static void main(String[] args) throws IOException {
        String context = new String(Files.readAllBytes(Paths.get("C:\\Users\\Maero\\Desktop\\新建文本文档 (5).txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(context.split("\\PL+"));
        Optional<String> optionalValue = wordList.stream().findAny();
        System.out.println(optionalValue.orElse("No word") + " contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println(result);
        result = optionalString.orElseGet(()-> Locale.getDefault().getDisplayName());
        System.out.println("result" + result);
     //   result = optionalString.orElseThrow(IllegalStateException::new);
        System.out.println("result" + result);
        optionalValue = wordList.stream().filter(s -> s.contains("red")).findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + " contains red"));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        wordList.stream().forEachOrdered(s -> System.out.println(s));



    }
}
