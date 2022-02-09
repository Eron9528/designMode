package cn.java.stage1.lesson4;

public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        Funciton1 f1 = ()->{};
        FunctionalInterfaceWithoutAnnotation f2 = ()->{};
    }

    @FunctionalInterface
    public interface Funciton1{
        void execute();
    }

    // @FunctionalInterface 并非必选的
    public interface FunctionalInterfaceWithoutAnnotation{
        void execute();
    }
}
