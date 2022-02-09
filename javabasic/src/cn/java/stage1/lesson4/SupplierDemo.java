package cn.java.stage1.lesson4;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Long> supplier = getValues();
        System.out.println(supplier.get());

        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        };

        // 效果同上
        Callable<String> callable1 = SupplierDemo::getHelloWorld;
    }

    public static String getHelloWorld(){
        return "Hello World";
    }

    public static Supplier<Long> getValues(){
        return System::currentTimeMillis;
    }
}
