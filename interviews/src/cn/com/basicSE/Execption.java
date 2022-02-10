package cn.com.basicSE;

public class Execption {

    public static void main(String[] args) {


        // 1. java 中的异常分为哪些种类
        /**
         编译时异常（CheckedException） ，运行时异常(RuntimeException)
         Java 认为编译时异常都是可以被处理的异常，所以必须显式的处理这些异常，否则无法进行编译
         对Checked 异常处理有两种方式：
              1. 当前方法知道如何处理改异常，使用try-catch
              2. 不知道如何处理，throw 出去
         运行时异常只有当系统运行时才会发生的异常，编译时不需要 try-catch
         若显示申明或者捕获将会对程序的可读性和运行效率影响很大。所以由系统自动检测并将它们交给缺省的异常处理程序。
         当然如果你有处理要求也可以显示捕获它们。*/

        // 2. 调用下面的方法，得到的返回值是什么？
        // 异常机制有这么一个原则如果在catch中遇到了return或者异常等能使该函数终止的话那么
        // 有finally就必须先执行完finally代码块里面的代码然后再返回值。
        System.out.println("=============题目1===============");
        System.out.println(getNum());


        // 3. error和exception的区别？
        // Error类和Exception类的父类都是Throwable类，他们的区别如下
        /**
         * Error类一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢出等。
         * 对于这类错误的导致的应用程序中断，仅靠程序本身无法恢复和和预防，遇到这样的错误，建议让程序终止。
         *
         * Exception类表示程序可以处理的异常，可以捕获且可能恢复。遇到这类异常，应该尽可能处理异常，
         * 使程序恢复运行，而不应该随意终止异常。
         *
         * Exception类又分为运行时异常（Runtime Exception）和受检查的异常(Checked Exception )，
         * 运行时异常;ArithmaticException,IllegalArgumentException，编译能通过，但是一运行就终止了，
         * 程序不会处理运行时异常，出现这类异常，程序会终止。而受检查的异常，要么用try。。。catch捕获，
         * 要么用throws字句声明抛出，交给它的父类处理，否则编译不会通过。
         *
         */


        // 4. java异常处理机制
        /**
         * Java对异常进行了分类，不同类型的异常分别用不同的Java类表示，所有异常的根类为java.lang.Throwable，
         * Throwable下面又派生了两个子类：Error和Exception，Error表示应用程序本身无法克服和恢复的一种严重问题。
         * Exception表示程序还能够克服和恢复的问题，其中又分为系统异常和普通异常，系统异常是软件本身缺陷所导致的问题，
         * 也就是软件开发人员考虑不周所导致的问题，软件使用者无法克服和恢复这种问题，
         * 但在这种问题下还可以让软件系统继续运行或者让软件死掉，例如，数组脚本越界（ArrayIndexOutOfBoundsException），
         * 空指针异常（NullPointerException）、类转换异常（ClassCastException）；
         * 普通异常是运行环境的变化或异常所导致的问题，是用户能够克服的问题，例如，网络断线，硬盘空间不够，发生这样的异常后，
         * 程序不应该死掉。
         * java为系统异常和普通异常提供了不同的解决方案，编译器强制普通异常必须try..catch处理或用
         * throws声明继续抛给上层调用方法处理，所以普通异常也称为checked异常，而系统异常可以处理也可以不处理，
         * 所以，编译器不强制用try..catch处理或用throws声明，所以系统异常也称为unchecked异常。
         *
         */

        // 5. 请写出你最常见的5个RuntimeException？
        /**
         *  a. java.lang.NullPointerException 空指针异常；出现原因：调用了未经初始化的对象或者是不存在的对象。
         *  b. java.lang.ClassNotFoundException 指定的类找不到；出现原因：类的名称和路径加载错误；
         *      通常都是程序试图通过字符串来加载某个类时可能引发异常。
         *  c. java.lang.NumberFormatException 字符串转换为数字异常；出现原因：字符型数据中包含非数字型字符。
         *  d. java.lang.IndexOutOfBoundsException 数组角标越界异常，常见于操作数组对象时发生。
         *  e. java.lang.IllegalArgumentException 方法传递参数错误。
         *  f. java.lang.ClassCastException 数据类型转换异常。
         *  g. java.lang.NoClassDefFoundException 未找到类定义错误。
         *  h. SQLException SQL异常，常见于操作数据库时的SQL语句错误。
         *  i. java.lang.InstantiationException实例化异常。
         *  j. java.lang.NoSuchMethodException 方法不存在异常。
         */


        // 6. throw和throws的区别
        /**
         *  throw : throw语句用在方法体内，表示抛出异常，由方法体内的语句处理。
         *          throw是具体向外抛出异常的动作，所以它抛出的是一个异常实例，执行throw一定是抛出了某种异常。
         *
         *  throws: throws语句是用在方法声明后面，表示如果抛出异常，由该方法的调用者来进行异常的处理。
         *          throws主要是声明这个方法会抛出某种类型的异常，让它的使用者要知道需要捕获的异常的类型。
         *          throws表示出现异常的一种可能性，并不一定会发生这种异常。
         */


        // 7. final、finally、finalize的区别？
        /**
         *    final：用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，被其修饰的类不可继承。
         *    finally：异常处理语句结构的一部分，表示总是执行。
         *    finalize：Object类的一个方法，在垃圾回收器执行的时候会调用被回收对象的此方法，
         *            可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。该方法更像是一个对象生命周期的临终方法，
         *            当该方法被系统调用则代表该对象即将“死亡”，但是需要注意的是，我们主动行为上去调用该方法并不会导致该对象“死亡”，
         *            这是一个被动的方法（其实就是回调方法），不需要我们调用。
         */

        System.out.println("=============题目2===============");




    }

    public static int getNum(){
        try{
            int a = 1/0;
            return 1;
        } catch (Exception e){
            return 2;
        } finally {
            return 3;
        }

    }
}
