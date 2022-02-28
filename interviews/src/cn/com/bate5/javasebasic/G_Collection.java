package cn.com.bate5.javasebasic;

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


        // 6. List和Map、Set的区别
        /**
         *      1 结构特点
         *              List和Set是存储单列数据的集合，Map是存储键和值这样的双列数据的集合；List中存储的数据是有顺序，
         *          并且允许重复；Map中存储的数据是没有顺序的，其键是不能重复的，它的值是可以有重复的，Set中存储的
         *          数据是无序的，且不允许有重复，但元素在集合中的位置由元素的hashcode决定，位置是固定的（Set集合
         *          根据hashcode来进行数据的存储，所以位置是固定的，但是位置不是用户可以控制的，所以对于用户来说set
         *          中的元素还是无序的）；
         *      2. 实现类
         *              List接口有三个实现类（LinkedList：基于链表实现，链表内存是散乱的，每一个元素存储本身内存地址的
         *          同时还存储下一个元素的地址。链表增删快，查找慢；ArrayList：基于数组实现，非线程安全的，效率高，
         *          便于索引，但不便于插入删除；Vector：基于数组实现，线程安全的，效率低）。
         *              Map接口有三个实现类（HashMap：基于hash表的Map接口实现，非线程安全，高效，支持null值和null键；
         *          HashTable：线程安全，低效，不支持null值和null键；LinkedHashMap：是HashMap的一个子类，
         *          保存了记录的插入顺序；SortMap接口：TreeMap，能够把它保存的记录根据键排序，默认是键值的升序排序）。
         *              Set接口有两个实现类（HashSet：底层是由HashMap实现，不允许集合中有重复的值，使用该方式时需要
         *          重写equals()和hashCode()方法；LinkedHashSet：继承与HashSet，同时又基于LinkedHashMap来进行实现，
         *          底层使用的是LinkedHashMp）。
         *      3. 区别
         *              List集合中对象按照索引位置排序，可以有重复对象，允许按照对象在集合中的索引位置检索对象，例如通过
         *          list.get(i)方法来获取集合中的元素；Map中的每一个元素包含一个键和一个值，成对出现，键对象不可以重复，
         *          值对象可以重复；Set集合中的对象不按照特定的方式排序，并且没有重复对象，但它的实现类能对集合中的对象按照
         *          特定的方式排序，例如TreeSet类，可以按照默认顺序，也可以通过实现Java.util.Comparator<Type>接口
         *          来自定义排序方式。
         *
         */


        // 7. HashMap 和HashTable有什么区别?
        /**
         *          HashMap是线程不安全的,HashMap是一个接口,是Map的一个子接口,是将键映射到值得对象,不允许键值重复,
         *      允许空键和空值;由于非线程安全,HashMap的效率要较HashTable的效率高一些.
         *          HashTable 是线程安全的一个集合,不允许null值作为一个key值或者Value值;
         *          HashTable是sychronize,多个线程访问时不需要自己为它的方法实现同步,而HashMap在被多个线程访问的
         *      时候需要自己为它的方法实现同步;
         *
         */

        // 8. 数组和链表分别比较适合用于什么场景，为什么？
        /**
         *      区别
         *              数组是将元素在内存中连续存储的；它的优点：因为数据是连续存储的，内存地址连续，所以在查找数据的时候
         *          效率比较高；它的缺点：在存储之前，我们需要申请一块连续的内存空间，并且在编译的时候就必须确定好它的
         *          空间的大小。在运行的时候空间的大小是无法随着你的需要进行增加和减少而改变的，当数据两比较大的时候，
         *          有可能会出现越界的情况，数据比较小的时候，又有可能会浪费掉内存空间。在改变数据个数时，增加、插入、
         *          删除数据效率比较低
         *              链表是动态申请内存空间，不需要像数组需要提前申请好内存的大小，链表只需在用的时候申请就可以，
         *          根据需要来动态申请或者删除内存空间，对于数据增加和删除以及插入比数组灵活。还有就是链表中数据在
         *          内存中可以在任意的位置，通过应用来关联数据（就是通过存在元素的指针来联系）
         *      链表和数组使用场景
         *              数组应用场景：数据比较少；经常做的运算是按序号访问数据元素；数组更容易实现，任何高级语言都支持；
         *          构建的线性表较稳定。
         *              链表应用场景：对线性表的长度或者规模难以估计；频繁做插入删除操作；构建动态性比较强的线性表。
         */


        // 9. Java中ArrayList和Linkedlist区别？
        /**
         *          ArrayList和Vector使用了数组的实现，可以认为ArrayList或者Vector封装了对内部数组的操作，比如向数组中添加，
         *      删除，插入新的元素或者数据的扩展和重定向。
         *          LinkedList使用了循环双向链表数据结构。与基于数组的ArrayList相比，这是两种截然不同的实现技术，
         *          这也决定了它们将适用于完全不同的工作场景。
         *          LinkedList链表由一系列表项连接而成。一个表项总是包含3个部分：元素内容，前驱表和后驱表，
         *          在JDK的实现中，无论LikedList是否为空，链表内部都有一个header表项，它既表示链表的开始，
         *          也表示链表的结尾。表项header的后驱表项便是链表中第一个元素，表项header的前驱表项便是链表中最后一个元素。
         */


        // 10. List a=new ArrayList()和ArrayList a =new ArrayList()的区别？
        /**
         *      List list = new ArrayList();这句创建了一个ArrayList的对象后把上溯到了List。此时它是一个List对象了，
         *      有些ArrayList有但是List没有的属性和方法，它就不能再用了。而ArrayList list=new ArrayList();
         *      创建一对象则保留了ArrayList的所有属性。 所以需要用到ArrayList独有的方法的时候不能用前者。
         */
        System.out.println("=============题目2===============");
        List a = new ArrayList();
        ArrayList b = new ArrayList();
        // 错误，没有该方法。
//        a.trimToSize();
        b.trimToSize();


        // 11. 要对集合更新操作时，ArrayList和LinkedList哪个更适合？
        /**
         *      1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
         *      2.如果集合数据是对于集合随机访问get和set，ArrayList绝对优于LinkedList，因为LinkedList要移动指针。
         *      3.如果集合数据是对于集合新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
         *
         *      ArrayList和LinkedList 是两个集合类，用于存储一系列的对象引用(references)。例如我们可以用ArrayList
         *      来存储一系列的String或者Integer。那 么ArrayList和LinkedList在性能上有什么差别呢？什么时候应该用
         *      ArrayList什么时候又该用LinkedList呢？
         *          时间复杂度
         *                  首先一点关键的是，ArrayList的内部实现是基于基础的对象数组的，因此，它使用get方法访问列表中的
         *              任意一个元素时(random access)，它的速度要比LinkedList快。LinkedList中的get方法是按照顺序
         *              从列表的一端开始检查，直到另外一端。对LinkedList而言，访问列表中的某个指定元素没有更快的方法了。
         *                  假设我们有一个很大的列表，它里面的元素已经排好序了，这个列表可能是ArrayList类型的也可能是
         *              LinkedList类型的，现在我们对这个列表来进行二分查找(binary search)，比较列表是ArrayList和
         *              LinkedList时的查询速度，可以得出ArrayList 比 LinkedList 的速度快很多。
         *                  这个结果不是固定的，但是基本上ArrayList的时间要明显小于LinkedList的时间。因此在这种情况下
         *              不宜用LinkedList。二分查找法使用的随机访问(random access)策略，而LinkedList是不支持快速的
         *              随机访问的。对一个LinkedList做随机访问所消耗的时间与这个list的大小是成比例的。而相应的，在ArrayList
         *              中进行随机访问所消耗的时间是固定的。
         *                  这是否表明ArrayList总是比 LinkedList性能要好呢？这并不一定，在某些情况下LinkedList的表现
         *              要优于ArrayList，有些算法在LinkedList中实现 时效率更高。比方说，利用Collections.reverse方法
         *              对列表进行反转时，其性能就要好些。看这样一个例子，加入我们有一个列表，要对其进行大量的插入和删除操作，
         *              在这种情况下LinkedList就是一个较好的选择。请看如下一个极端的例子，我们重复的在一个列表的开端插入
         *              一个元素：
         *          空间复杂度
         *                  每个Entry对象reference列表 中的一个元素，同时还有在LinkedList中它的上一个元素和下一个元素。
         *              一个有1000个元素的LinkedList对象将有1000个链接在一起 的Entry对象，每个对象都对应于列表中的一个元素。
         *              这样的话，在一个LinkedList结构中将有一个很大的空间开销，因为它要存储这1000个 Entity对象的相关信息。
         *                  ArrayList使用一个内置的数组来存 储元素，这个数组的起始容量是10.当数组需要增长时，新的容量按如下
         *              公式获得：新容量=(旧容量*3)/2+1，也就是说每一次容量大概会增长50%。 这就意味着，如果你有一个包含大量
         *              元素的ArrayList对象，那么最终将有很大的空间会被浪费掉，这个浪费是由ArrayList的工作方式本身造成 的。
         *              如果没有足够的空间来存放新的元素，数组将不得不被重新进行分配以便能够增加新的元素。对数组进行重新分配，
         *              将会导致性能急剧下降。如果我们知道一个 ArrayList将会有多少个元素，我们可以通过构造方法来指定容量。
         *              我们还可以通过trimToSize方法在ArrayList分配完毕之后去掉浪 费掉的空间。
         *          总结
         *              1．对ArrayList和 LinkedList而言，在列表末尾增加一个元素所花的开销都是固定的。对ArrayList而言，
         *              主要是在内部数组中增加一项，指向所添加的元素，偶尔可能会导致对数组重新进行分配；而对LinkedList而言，
         *              这个开销是统一的，分配一个内部Entry对象。
         *              2．在ArrayList的中间插入或删除一个元素意味着这个列表中剩余的元素都会被移动；而在LinkedList的中间
         *              插入或删除一个元素的开销是固定的。
         *              3．LinkedList不支持高效的随机元素访问。
         *              4．ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则
         *              体现在它的每一个元素都需要消耗相当的空间。
         *              可以这样说：当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用
         *              ArrayList会提供比较好的性能；当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中
         *              的元素时,就应该使用LinkedList了。
         */


        // 12. 请用两个队列模拟堆栈结构
        /**
         *      两个队列模拟一个堆栈，队列是先进先出，而堆栈是先进后出。模拟如下
         *      队列a和b
         *          （1）入栈：a队列为空，b为空。例：则将”a,b,c,d,e”需要入栈的元素先放a中，a进栈为”a,b,c,d,e”
         *          （2）出栈：a队列目前的元素为”a,b,c,,d,e”。将a队列依次加入Arraylist集合a中。以倒序的方法，
         *              将a中的集合取出，放入b队列中，再将b队列出列。代码如下：
         */
        System.out.println("=============题目3===============");
        Queue<String> aQueue = new LinkedList<>();
        Queue<String> bQueue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<String>();
        // 往 a 队列添加元素
        aQueue.offer("a");
        aQueue.offer("b");
        aQueue.offer("c");
        aQueue.offer("d");
        aQueue.offer("e");
        System.out.println("进栈：");
        for (String q : aQueue){
            list.add(q);
            System.out.print(q);
        }
        // 以倒序的方法取出 （ a 队列依次加入 list 集合）之中的值，加入 b 队列
        for(int i = list.size()-1; i>=0;i--){
            bQueue.offer(list.get(i));
        }
        // 打印出栈队列
        System.out.println("");
        System.out.println("出栈：");
        for (String q:bQueue){
            System.out.print(q);
        }


        // 13. Collection和Map的集成体系
        /**
         *
         */


        // 14. Map中的key和value可以为null么？
        /**
         *    HashMap对象的key、value值均可为null。
         *    HashTable对象的key、value值均不可为null。
         *
         *    且两者的的key值均不能重复，若添加key相同的键值对，后面的value会自动覆盖前面的value，但不会报错。
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