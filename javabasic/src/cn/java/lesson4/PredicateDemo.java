package cn.java.lesson4;

import java.io.File;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<File> predicate = file -> {
            return false;
        };
    }
}
