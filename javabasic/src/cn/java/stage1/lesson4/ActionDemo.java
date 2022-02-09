package cn.java.stage1.lesson4;

public class ActionDemo {
    public static void main(String[] args) {
        // 匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        // invoke dynamic 指令 @Since JDk 1.7
        // 请记住 java.lang.invoke.MethodHandle
        // java.lang.invoke.InvokeDynamic
        Runnable runnable1 = ()->{};

    }
}
