package cn.a_designmode.observer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Vector;

public class MyObservable implements Observable {
    Vector<MyObserver> vector = new Vector();
    @Override
    public void addListener(InvalidationListener listener) {
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        vector.removeElement(listener);
    }
}
