package cn.com.basicSE;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s = new Student("angle",10);
        Student b = (Student)s.clone();
        System.out.println(s);
        System.out.println(b);

        //  正常拷贝 不会，引用对象是浅拷贝
        // 1. Clone 浅拷贝如何修改成为深拷贝
        System.out.println("=============题目1===============");
        System.out.println(s.getName()==b.getName());


        // 2. goto
        // goto 只作为保留字，不能使用

        // 3. & 和 && 的区别
        // 注意 && 需要注意 短路， 先判断是否为 null 再判断其他
        System.out.println("=============题目2===============");

        int a = 1&1;
        System.out.println(a);


        // 4. 如何跳出多重循环
        // 使用 break + 标记 可以直接跳出循环
        // 避免使用这样的 break 或则 continue ， 会引起不必要的麻烦
        System.out.println("=============题目3===============");
        A: for (int i = 0; i<10 ; i++){
            for (int j = 0; j<10 ; j++){
                for (int k = 0; k<10 ; k++){
                    System.out.println("1");
                    if (k==3)
                        break A;
                }
            }
        }

        // 5. 两个对象值相等（x.equals(y) == true） ,但却可有不同的 hashCode ,这句话对不对
        // 不对，如果对象x 和 y 满足以上要求，hashCode 肯定相同，

        System.out.println("=============题目4===============");





        System.out.println("=============题目1===============");

    }

    static class Student implements Cloneable {

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Object clone() throws CloneNotSupportedException{
            // 再克隆方法里面实现对引用的复制操作。
            Student s = (Student)super.clone();
            s.name = new String(s.name);
            return s;
        }
    }
}

