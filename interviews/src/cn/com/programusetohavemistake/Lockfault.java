package cn.com.programusetohavemistake;

public class Lockfault {

    public static void main(String[] args) {
        Interesting interesting = new Interesting();
        new Thread(()->interesting.add()).start();
        new Thread(()->interesting.compare()).start();
    }

}

class Interesting{
    volatile int a = 1;
    volatile int b = 1;

    public void add(){
        System.out.println("add start");
        for (int i = 0; i<10000; i++){
            a++;
            b++;
        }
        System.out.println("add end");
    }

    public void compare(){
        System.out.println("compare start");
        for (int i=0; i<10000; i++){
            // a 始终等于b 吗
            if (a<b){
                System.out.println("a:" + a + "   b:" + b + " , " + (a>b));
                // 最后 a>b应该是是是始终是 false 吗？
            }
        }
        System.out.println("compare done");
    }
}
