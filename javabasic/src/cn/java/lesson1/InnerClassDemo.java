package cn.java.lesson1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;

/**
 * 内置类实例
 *      匿名内置类实例
 *          经典场景
 *              Java Event / Listener
 *              Java Concurrent
 *              Spring Template
 *          基本特性
 *              无名称类
 *              执行模块（方法，block） 内部或者代码
 *                  static block
 *                  实例 block
 *                  方法
 *                  构造器
 *              并非特殊的类结构
 *          基本特点
 *              基于多态（多数基于接口编程）
 *              实现类无需名称
 *              允许多个抽象方法
 *          编程局限
 *              代码臃肿
 *              强类型约束
 *              接口方法升级
 *
 */

public class InnerClassDemo {

    // static 块
    static {
        new Runnable(){
            @Override
            public void run() {

            }
        };
    }

    // 实例块
    {
        new Callable<>(){
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
    }

    // 构造器
    public InnerClassDemo(){
        new Comparable<>() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

    /**  5. 知识点5. 静态代码块和实例代码块的区别
     *      静态代码块和实例代码块的区别
     *          1. static 静态代码块的特点
     *              只要被编译运行的类中有静态代码块， static 块中的代码就会优先被执行
     *              static 静态代码中的变量只能是静态的
     *              static 静态代码块中的代码指挥执行一遍
     *          2. 普通代码块中的特点
     *              带有普通代码块的类被编译执行时会执行普通代码块中的代码
     *              普通代码块中代码执行的优先度在静态代码之后（与代码顺序无关）
     *              普通代码在每次对象实例化的时候都会执行
     *              普通代码块中变量只能时非静态的
     */

    public static void main(String[] args) {
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        };
    }

    static class PropertyChangeListenerImpl implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            };
        }
    }
}
