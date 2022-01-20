package cn.a_designmode.observer;

public interface ISubject {
    void attach(IObserver observer);
    void detach(IObserver observer);
    void inform();

}
