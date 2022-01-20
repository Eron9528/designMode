package cn.a_java8;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionIntoMaps {

    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public static Stream<Person> people(){
            return Stream.of(new Person(1001, "小明"),new Person(1002,"小红"), new Person(1003, "小李"));
        }

        public static void main(String[] args) {
            Map<Integer,String> idToName = people().collect(Collectors.toMap(Person::getId,Person::getName));
            System.out.println("idToName" + idToName);

            Map<Integer,Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
            System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

            idToPerson = people().collect(Collectors.toMap(Person::getId,Function.identity()
                    ,(existingValue, newValue)->{throw new IllegalStateException();}, TreeMap::new));
            System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

            Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
            Map<String,String> languagesNames = locales.collect(
                    Collectors.toMap(
                            Locale::getDisplayLanguage,
                            locale -> locale.getDisplayLanguage(locale),
                            (existingValue, newValue) -> existingValue
                    )
            );
            System.out.println("languageNames: " + languagesNames);

        }
    }
}
