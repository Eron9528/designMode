package cn.com.bate5.javasehigh.c_designmode_garbagecollect.a_designmode;

import java.util.Enumeration;
import java.util.Vector;

public class L_Observer {
    public static void main(String[] args) {
        Subject subject = new MySubject();
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();

        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObservers();
        subject.del(observer1);
        subject.notifyObservers();
    }
}

interface Observer{
    public void update();
}

class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}

interface Subject{
    /* 增加观察者 */
    public void add(Observer observer);
    /* 删除观察者 */
    public void del(Observer observer);
    /* 通知所有的观察者 */
    public void notifyObservers();
    /* 自身操作 */
    public void operation();
}

 abstract class AbstractSubject implements Subject{

    private Vector<Observer> vector = new Vector<>();

     @Override
     public void add(Observer observer) {
        vector.add(observer);
     }

     @Override
     public void del(Observer observer) {
        vector.removeElement(observer);
     }

     @Override
     public void notifyObservers() {
         Enumeration<Observer> enumo = vector.elements();
         while (enumo.hasMoreElements()){
             enumo.nextElement().update();
         }
     }

 }

 class MySubject extends AbstractSubject{
     @Override
     public void operation() {
         System.out.println("update self!");
         notifyObservers();
     }

 }