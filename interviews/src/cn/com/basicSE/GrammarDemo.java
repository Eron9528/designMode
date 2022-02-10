package cn.com.basicSE;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class GrammarDemo {

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
        // 不对，如果对象x 和 y 满足以上要求，hashCode 肯定相同，两个hashCode 相同的对象不一定相同
        // equals 方法必须满足自反性， 一致性，传递性，对称性
        // 重写equals 一定要重写 hashCode  ?


        // 6. 是否可以继承String
        // String 是 final 的不可以被继承，继承String 本身就是一种错误的行为，正确的行为是使用和依赖


        // 7. 当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，
        // 那么这里到底是值传递还是引用传递?

        // 8. 重载（overload）和重写（override）的区别？重载的方法能否根据返回类型进行区分？

        // 9. 为什么函数不能根据返回类型来区分重载？
        // 因为不能区分调用的是哪个方法

        // 10. char 型变量中能不能存储一个中文汉字，为什么？
        // char 类型可以存储一个中文汉字，因为Java中使用的编码是 Unicode（不选择任何特定的编码，
        // 直接 使用字符在字符集中的编号，这是统一的唯一方法），一个 char 类型占 2 个字节（16 比特），
        // 所以放一个中文是没问题的。

        // 11. 抽象类和接口的异同点？

        // 12. 抽象的(abstract)方法是否可同时是静态的(static), 是否可同时是本地方法(native），是否可同时被synchronized
        // 都不能，静态方法不能被重写，所以不可以，抽象方法不涉及本地代码本地实现所以不是本地方法，抽象方法不涉及具体实现细节
        // 所以不能同时被synchronized

        // 13. 阐述静态变量和实例变量的区别？
        // 静态变量属于类，是类变量，不管类创建了多少个对象，都只用一个拷贝
        // 实例变量必须依赖某一实例对象，静态变量可以实现让多个对象共享一个变量

        // 14. ==和equals的区别？
        // 一个方法，一个运算符
        // ==： 如果比较基本数据类型，比较的是值，如果是比较引用类型，则比较的是对象的地址值是否相同
        // equals: 用来比较方法的两个对象是否相等。

        System.out.println("=============题目4===============");

        String ab = "sb";
        String sb = new String("sb");
        if (ab==sb){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


        // 15 . String s = "Hello";s = s + " world!";这两行代码执行后，原始的String对象中的内容到底变了没有？
        // 没有变，只不过s 重新指向了一个新的对象， new String 的操作对内存消耗较大，建议如果需要使用可变字符串
        // 直接使用 StringBuffer 。
        System.out.println("=============题目5===============");


        System.out.println("=============题目1===============");

    }

    public int getValue(){return 1;}


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

