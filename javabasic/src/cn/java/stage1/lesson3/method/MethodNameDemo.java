package cn.java.stage1.lesson3.method;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class MethodNameDemo {
    public static void main(String[] args) {

        // 方法表示执行动作
        // Runnable#run()
        // Action#execute();
        // Callable#call();

        // 动词 + 形容词
        // 副词形容动词或形容词
        Stream.of(1,2,3).forEachOrdered(System.out::println);

        //
        Lock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();   // 动词 + 副词
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    // 动词+名词
    // getValues

    // 动词+名词+副词
    // getValuesSynchronously

    public class ViewRender {  // 名词

        public void render(){   // 单一动词

        }

        // 同步渲染
        public void renderSynchronously(){  // 动词 + 副词

        }
    }
}
