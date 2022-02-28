package cn.com.bate5.javasehigh.c_designmode_garbagecollect.a_designmode;

public class H_ClassAdapter {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();
    }
}

class Source{
    public void method1(){
        System.out.println(" this is original method!");
    }
}

interface Targetable{
    // 与原类的方法相同
    public void method1();
    // 新类的方法
    public void method2();
}

class Adapter extends Source implements Targetable{

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}