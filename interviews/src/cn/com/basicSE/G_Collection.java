package cn.com.basicSE;

import java.util.*;
import java.util.stream.Collectors;

public class G_Collection {

    public static void main(String[] args) {

        // 1. HashMap 排序题，
        /**
         * 已知一个 HashMap<Integer，User>集合， User 有 name（String）和 age（int）属性。请写一个方法实现对
         * HashMap 的排序功能，该方法接收 HashMap<Integer，User>为形参，返回类型为 HashMap<Integer，User>，
         * 要求对 HashMap 中的 User 的 age 倒序进行排序。排序时 key=value 键值对不得拆散。
         */
        System.out.println("=============题目1===============");
        HashMap<Integer, User> userMap = new HashMap<Integer, User>();
        userMap.put(1, new User("xiaoWang",12));
        userMap.put(2, new User("xiaoLee",13));
        userMap.put(4, new User("xiaoZhang",12));
        userMap.put(3, new User("xiaoLiu",15));
        LinkedHashMap<Integer,User>  map = (LinkedHashMap<Integer, User>) getSortHashMapResult(userMap);
        System.out.println(map);


        // 2. 集合安全性的问题
        /**
         * 请问 ArrayList、HashSet、HashMap 是线程安全的吗？如果不是我想要线程安全的集合怎么办？
         * 我们都看过上面那些集合的源码（如果没有那就看看吧），每个方法都没有加锁，显然都是线程不安全的。话又说
         * 过来如果他们安全了也就没第二问了。
         * 在集合中 Vector 和 HashTable 倒是线程安全的。你打开源码会发现其实就是把各自核心方法添加上了
         * synchronized 关键字。
         * Collections 工具类提供了相关的 API，可以让上面那 3 个不安全的集合变为安全的。
         * 上面几个函数都有对应的返回值类型，传入什么类型返回什么类型。打开源码其实实现原理非常简单，就是将集
         * 合的核心方法添加上了 synchronized 关键字
         */


        // 3. ArrayList 内部用什么实现的？
        /**
         *   ArrayList 内部用Object[] 实现的。
         *   接下来我们分别分析 ArrayList 的构造、add、remove、clear 方法的实现原理
         *      构造函数
         *          空参构造
         *              array 是一个 Object[]类型。当我们 new 一个空参构造时系统调用了 EmptyArray.OBJECT 属性，EmptyArray 仅
         *              仅是一个系统的类库,也就是说当我们 new 一个空参 ArrayList 的时候，系统内部使用了一个 new Object[0]数组
         *          带参构造 1
         *              该构造函数传入一个 int 值，该值作为数组的长度值。如果该值小于 0，则抛出一个运行时异常。如果等于 0，则
         *              使用一个空数组，如果大于 0，则创建一个长度为该值的新数组
         *          带参构造 2
         *              如果调用构造函数的时候传入了一个 Collection 的子类，那么先判断该集合是否为 null，为 null 则抛出空指针异
         *              常。如果不是则将该集合转换为数组 a，然后将该数组赋值为成员变量 array，将该数组的长度作为成员变量 size。这
         *              里面它先判断 a.getClass 是否等于 Object[].class，其实一般都是相等的，我也暂时没想明白为什么多加了这个判断，
         *              toArray 方法是 Collection 接口定义的，因此其所有的子类都有这样的方法，list 集合的 toArray 和 Set 集合的 toArray
         *              返回的都是 Object[]数组。
         *      add 方法
         *          1.首先将成员变量 array 赋值给局部变量 a，将成员变量 size 赋值给局部变量 s。
         *          2.判断集合的长度 s 是否等于数组的长度（如果集合的长度已经等于数组的长度了，说明数组已经满了，该重新
         *              分配新数组了），重新分配数组的时候需要计算新分配内存的空间大小，如果当前的长度小于
         *              MIN_CAPACITY_INCREMENT/2（这个常量值是 12，除以 2 就是 6，也就是如果当前集合长度小于 6）则分配 12 个
         *              长度，如果集合长度大于 6 则分配当前长度 s 的一半长度。这里面用到了三元运算符和位运算，s >> 1，意思就是将
         *              s 往右移 1 位，相当于 s=s/2，只不过位运算是效率最高的运算
         *          3、将新添加的 object 对象作为数组的 a[s]个元素。
         *          4、修改集合长度 size 为 s+1
         *          5、modCotun++,该变量是父类中声明的，用于记录集合修改的次数，记录集合修改的次数是为了防止在用迭代
         *              器迭代集合时避免并发修改异常，或者说用于判断是否出现并发修改异常的。
         *          6、return true，这个返回值意义不大，因为一直返回 true，除非报了一个运行时异常。
         *      remove 方法
         *          1、先将成员变量 array 和 size 赋值给局部变量 a 和 s
         *          2、判断形参 index 是否大于等于集合的长度，如果成了则抛出运行时异常
         *          3、获取数组中脚标为 index 的对象 result，该对象作为方法的返回值
         *          4、调用 System 的 arraycopy 函数，拷贝原理如下图所示。
         *          5、接下来就是很重要的一个工作，因为删除了一个元素，而且集合整体向前移动了一位，因此需要将集合最后一
         *              个元素设置为 null，否则就可能内存泄露。
         *          6、重新给成员变量 array 和 size 赋值
         *          7、记录修改次数
         *          8、返回删除的元素（让用户再看最后一眼）
         *      clear 方法
         *          如果集合长度不等于 0，则将所有数组的值都设置为 null，然后将成员变量 size 设置为 0 即可，最后让修改记录加 1。
         *
         */


        // 4. 并发集合和普通集合如何区别？
        /**
         *      并发集合常见的有 ConcurrentHashMap、ConcurrentLinkedQueue、ConcurrentLinkedDeque 等。并发集合
         *      位 于 java.util.concurrent 包 下 ， 是 jdk1.5 之 后 才 有 的 ， 主 要 作 者 是 Doug Lea完成的。
         *      在 java 中有普通集合、同步（线程安全）的集合、并发集合。普通集合通常性能最高，但是不保证多线程的安全
         *      性和并发的可靠性。线程安全集合仅仅是给集合添加了 synchronized 同步锁，严重牺牲了性能，而且对并发的效率就
         *      更低了，并发集合则通过复杂的策略不仅保证了多线程的安全又提高的并发时的效率。
         */


        // 5. List 的三个子类的特点
        /**
         *      ArrayList 底层结构是数组,底层查询快,增删慢。
         *      LinkedList 底层结构是链表型的,增删快,查询慢。
         *      voctor 底层结构是数组 线程安全的,增删慢,查询慢。
         */


    }

    private static HashMap<Integer,User> getSortHashMapResult(HashMap<Integer, User> map) {
        LinkedHashMap<Integer,User> sortEntryList =  map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().getAge()-o1.getValue().getAge())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue
                        ,(newValue,oldValue)->{throw new IllegalStateException();},LinkedHashMap::new));
        return sortEntryList;
    }
}


class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}