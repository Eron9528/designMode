package cn.java.lesson3.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GenericWildcardsTypeDemo {
    public static void main(String[] args) {

        // 泛型上界通配符配型
        // Number -> Byte, Short, Integer, Long
        List<Number> numbers = new ArrayList<>();
        upperBoundedWildcards(numbers);
        unboundedWildcards(numbers);
        lowerBoundedWildcards(numbers);

    }

    private static void lowerBoundedWildcards(List<Number> numbers) {
        lowerBoundedWildcardsDemo(numbers, numbers);
    }

    private static void lowerBoundedWildcardsDemo(List<? extends Number> producer, List<? super Number> consumer) {
        // PECS stands for producer-extends, consumer-super.
        // 读取数据（生产者）使用 extends
        for(Number number : producer){

        }
        // 操作输出（消费者）使用 super
        consumer.add(Integer.valueOf(1));
    }

    private static void unboundedWildcards(List<Number> numbers){
        // 完全通配配型
        // 在运行时与非通配泛型会出现方法签名冲突
        // 然后完全通配类型，可以适配任意类型，比如集合
        // 反而具体类型泛型会限制类型范围
        unboundedWildcardsDemo(numbers);
    }
    public static void unboundedWildcardsDemo(Iterable<?> iterable){
        for(Object e:iterable)
            System.out.println(e);
    }

    private static void upperBoundedWildcards(List<Number> numbers){
        numbers.add(Byte.valueOf((byte)1));
        numbers.add(Short.valueOf((short)1));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));
        List<Byte> bytes = Arrays.asList((byte)5);
        numbers.addAll(bytes);
        // 被操作（处理）的对象，需要更为抽象类型， Number
        // 待整合（输入）的对象，可以是具体的类型
        upperBoundedWildcardsDemo(numbers, System.out::println);
    }

    public static void upperBoundedWildcardsDemo(Iterable<? extends Number> iterable, Consumer<Object> consumer){
        for(Object e : iterable){
            consumer.accept(e);
        }

    }
}
