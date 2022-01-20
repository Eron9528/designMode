package cn.a_java8;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("小明", 12, true));
        studentList.add(new Student("小红", 12, false));
        studentList.add(new Student("小绿", 12, true));
        studentList.add(new Student("小黑", 12, false));
        studentList.add(new Student("小蓝", 14, true));
        studentList.add(new Student("小紫", 13, false));

        function2(studentList);

    }

    private static void function2(List<Student> studentList) {
        long count = studentList.parallelStream().filter(student -> student.getAge()>12).count();


        System.out.println(count);
    }

    private static void function1(List<Student> studentList) {

    }
}
