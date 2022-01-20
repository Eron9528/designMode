package cn.a_designmode.observer;

import java.util.Vector;

public class ConcreteSubject implements ISubject{
    Vector<IObserver> observers = new Vector<>();
    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {
        Event evt = new Event();
        for(IObserver ob:observers){
            ob.update(evt);
        }
    }
}
