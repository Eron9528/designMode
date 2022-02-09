package cn.java.stage1.lesson1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *      Lambda 表达式
 *          基本特点
 *              流程编排清晰
 *              函数类型编程
 *              改善代码臃肿
 *              兼容接口升级
 *          实现手段
 *              @FunctionnallInterface 接口
 *              Lambda 语法
 *              方法引用
 *              接口 default 方法实现
 *          编程局限
 *              单一抽象方法
 *              Lambda 调试困难
 *              Stream API 操作能力有限
 *
 *
 *      函数式接口
 *          使用场景
 *              当接口升级时，添加了新的抽象方法，此时基于老的接口的实现类必然会遇到编译问题。默认方法的
 *              出现能解决以上的问题，同时也能为实现类提供默认或样板实现，减少实现类的负担，如无需再使用
 *              Adapter 实现。
 *              提示： 默认方法不列入 @FunctionInterface 方法计算
 *          基本特性
 *              所有函数式接口都引用一段执行代码
 *              函数式接口没有固定的类型，固定模式（SCFP = Supplier + Consummer + Function + Predicate） + Action
 *              利用方法引用来实现模式匹配
 *
 *
 */
public class LambdaDemo {

    // SCFP = Supplier + Consumer + Function + Predicate
    // 四种模式 缺少（Action）模式

    // Supplier 模式
    private static void showSupplier(){
        String string = "Hello World";
        Supplier<String> string2 = ()-> "Hello World";
        Supplier<String> string3 = ()-> new Integer(2).toString();
    }

    // Consumer
    private static void showConsumer(){
        // 匿名类基本写法
        new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                println(evt);
            }
        };
        // Lambda写法
        PropertyChangeListener listener1 = evt -> {
            println(evt);
        };
        // 属于有入参，没有返回，与 println(Object)一样
        // Lambda 简略写法
        PropertyChangeListener listener = LambdaDemo::println;
    }

    // Function
    private static void showFunction(){
        Function<String, Integer> f = LambdaDemo::compareTo;
    }

    private static Integer compareTo(String value){
        return value.compareTo("Hello World");
    }

    public static void main(String[] args) {

        /** 变量、实例变成了一段代码 */
        Action action = ()->{

        };



    }

    public static void println(Object object){
        System.out.println(object);
    }

    /** 自己定义的 Lambda 接口，有且只能有一个非 default 方法*/
    @FunctionalInterface
    public interface Action{
        public abstract void execute();

        default void doexcute(){
            execute();
        }
        default void doexcute2(){
            execute();
        }
    }

    public static void stream(){
        Stream.of(1,2,3,4,5).map(String::valueOf);
    }
}
