package cn.com.basicSE.g_multithreading.a_threadnote;

public class TestTwoThreadShareOneData {

    /**
     *      2. 多个线程行为不一致共同操作一个数据
     *      如果每个线程执行的代码不同，这时候需要用不同的Runnable对象，有如下两种方式来实现这些Runnable对象之间的数据共享：
     *
     *      补充：上面两种方式的组合：将共享数据封装在另外一个对象中，每个线程对共享数据的操作方法也分配到那个对象身上去完成，
     *          对象作为这个外部类中的成员变量或方法中的局部变量，每个线程的Runnable对象作为外部类中的成员内部类或局部内部类。
     *
     *      总之，要同步互斥的几段代码最好是分别放在几个独立的方法中，这些方法再放在同一个类中，这样比较容易实现它们之间的同步互斥和通信。
     */

    public static void main(String[] args) {
        // 公共数据
        final ShareData2 shareData2 = new ShareData2();
        for(int i = 0; i < 4; i++){

            // 将共享数据封装在另外一个对象中，然后将这个对象逐一传递给各个Runnable对象。每个线程对共享数据的操作方法也
            // 分配到那个对象身上去完成，这样容易实现针对该数据进行的各个操作的互斥和通信。
//            if (i%2==0){
//                new Thread(new RunnableCusToInc2(shareData2),"Thread"+i).start();
//            }else{
//                new Thread(new RunnableCusToDec2(shareData2),"Thread" + i).start();
//            }

            // 将这些Runnable对象作为某一个类中的内部类，共享数据作为这个外部类中的成员变量，每个线程对共享数据的操作
            // 方法也分配给外部类，以便实现对共享数据进行的各个操作的互斥和通信，作为内部类的各个Runnable对象调用外部类
            // 的这些方法。
            if (i%2==0){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i<5; i++){
                            shareData2.inc();
                        }
                    }
                },"Thread"+i).start();
            }else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0;i<5;i++){
                            shareData2.dec();
                        }
                    }
                }, "Thread" + i).start();
            }
        }
    }




}
class ShareData2{
    private int num = 10;
    public synchronized void inc(){
        num ++;
        System.out.println(Thread.currentThread().getName() + ": invoke inc method num = " + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void dec(){
        num--;
        System.out.println(Thread.currentThread().getName() + ": invoke dec method num = " + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//封装共享数据类
class RunnableCusToInc2 implements Runnable{
    private ShareData2 shareData2;
    public RunnableCusToInc2(ShareData2 shareData2){
        this.shareData2 = shareData2;
    }
    @Override
    public void run() {
        for(int i = 0; i<5;i++){
            shareData2.inc();
        }
    }
}
// 封装共享数据类
class RunnableCusToDec2 implements Runnable{
    // 封装共享数据
    private ShareData2 shareData2;
    public RunnableCusToDec2(ShareData2 shareData2){
        this.shareData2 = shareData2;
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            shareData2.dec();
        }
    }
}


