package cn.com.java.cuncurrent.lessona15lockcondition;

public class Pai1M {
    public static void main(String[] args) {
        fore();
        System.out.println("1");
    }

    static void fore(){
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        });
        a.start();

    }
}
