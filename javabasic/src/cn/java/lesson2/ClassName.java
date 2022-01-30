package cn.java.lesson2;

import java.lang.reflect.Field;

/**
 *    Java 接口设计
 *      通用设计 - 可访问性
 *          四种修饰符
 *              public
 *              (default)
 *              private : 不能用于最外层修饰 class
 *              protected : 不能用于最外层修饰 class
 *
 *      通用设计 - 可继承性
 *          final: final 不具备继承性，仅用于实现类，不能与 abstract 关键字同时修饰类
 *          非 final: 最常见/默认的设计手段，可继承性依赖于可访问性
 *
 *      具体类设计
 *          常见场景
 *              功能组件
 *                  HashMap
 *              接口/抽象类实现
 *                  HashMap <- AbstractMap <- Map
 *              数据对象
 *                  POJO
 *              工具辅助
 *                  *Utils
 *                  ViewHelper
 *                  Helper
 *          命名模式
 *              前缀： “Default” , "Generic" , "Common" , "Basic"
 *              后缀： “Impl”
 *
 *      抽象类设计
 *          常见场景
 *              接口通用实现（模板模式）
 *              状态/行为继承
 *              工具类
 *          常见模式
 *              抽象程度介于类和接口之间（java8 + 可完全由接口代替）
 *              以 Abstract 或 Basic 类名前缀
 *                  java.util.AbstractCollection
 *                  javax.sql.rowset.BaseRowSet
 *
 *      接口设计
 *          常见场景
 *              上下游系统（组件）通讯契约
 *                  API
 *                  RPC
 *              常量定义
 *          常见模式
 *              无状态 （Stateless）
 *              完全抽象 （ <Java8 ）
 *              局部抽象 （ >Java8 ）
 *              单一抽象 （ Java8 函数式接口 ）
 *
 *      内置类设计
 *          常见场景
 *              临时数据存储类：java.lang.ThreadLocal.ThreadLocalMap
 *              特殊用途的 API 实现：java.util.Collections.UnmodifiableCollection
 *              Builder 模式 （接口）：java.util.stream.Stream.Builder
 *
 *      枚举类设计
 *          枚举实际是 final class, 他的成员修饰符是 public final static , values() 是Java 编译器做的字节码提升
 *          场景：Java 枚举引入之前的模拟枚举实现类
 *          模式：
 *              成员用常量表示，并且类型为当前类型
 *              常用关键字 final 修饰类
 *              非 public 构造器
 *          基本特性：
 *              类结构 （强类型）
 *              继承 java.lang.Enum
 *              不可显示的继承和被继承
 *
 *
 *
 */

public class ClassName {

    public static void main(String[] args) {
    }
}
