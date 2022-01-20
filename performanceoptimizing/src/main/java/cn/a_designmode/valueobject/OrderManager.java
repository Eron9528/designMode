package cn.a_designmode.valueobject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderManager extends UnicastRemoteObject implements IOrderManager {

    protected  OrderManager() throws RemoteException{
        super();
    }

    private static final long serialVersionUID = 1L;

    @Override
    public Order getOrder(int id) throws RemoteException {
        Order order = new Order();
        order.setClientName("billy");
        order.setNumber(20);
        order.setProductName("desk");
        return order;
    }

    @Override
    public String getClientName(int id) throws RemoteException {

        return "billy";
    }

    @Override
    public String getProdName(int id) throws RemoteException {
        return "desk";
    }

    @Override
    public int getNumber(int id) throws RemoteException {
        return 20;
    }
}
