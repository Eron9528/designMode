package cn.com.javasehigh.c_designmode_garbagecollect.a_designmode;

public class J_Decorator {
    public static void main(String[] args) {
        Sourceable source = new Source2();
        Decorator decorator = new Decorator(source);
        decorator.method();
    }
}

interface Sourceable{
    void method();
}

class Source2 implements Sourceable{
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}

class Decorator implements Sourceable{
    private Sourceable source;
    public Decorator(Sourceable source){
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator");
        source.method();
        System.out.println("after decorator");
    }
}
