package cn.com.javasehigh.c_designmode_garbagecollect.a_designmode;


/*
    基本思路和类的适配器模式相同，只是将 Adapter 类作修改，这次不继承 Source 类，而是持有 Source 类的实
例，以达到解决兼容性的问题
 */
public class I_ObjectAdapter {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable wrapper = new Wrapper(source);
        wrapper.method1();
        wrapper.method2();
    }

}

class Wrapper implements Targetable{

    private Source source;

    public Wrapper(Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
