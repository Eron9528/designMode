package cn.com.java.cuncurrent.lesson2jmm;

public class VolatileTest {
    int x = 0;
    volatile boolean v = false;
    public void writer(){
        x = 42;
        v = true;
    }
    public void reader(){
        if (v == true)
            System.out.println(x);
    }

    /**
     * 直觉上看，应该是 42，那实际应该是多少呢？这个要看 Java 的版本，如果在低于 1.5 版本上运行，x 可能是 42，
     * 也有可能是 0；如果在 1.5 以上的版本上运行，x 就是等于 42。
     * Java 内存模型在 1.5 版本对 volatile 语义进行了增强。怎么增强的呢？答案是一项 Happens-Before 规则。
     */
    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.writer();
        volatileTest.reader();
    }
}
