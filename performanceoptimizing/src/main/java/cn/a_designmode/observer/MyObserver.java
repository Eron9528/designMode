package cn.a_designmode.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
    private String name;
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + o + arg);
    }
}
