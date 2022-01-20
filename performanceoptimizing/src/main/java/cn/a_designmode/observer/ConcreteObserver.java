package cn.a_designmode.observer;

public class ConcreteObserver implements IObserver{
    @Override
    public void update(Event event) {
        System.out.println("observer receives information");
    }
}
