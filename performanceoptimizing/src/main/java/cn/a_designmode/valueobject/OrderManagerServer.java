package cn.a_designmode.valueobject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class OrderManagerServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            IOrderManager usermanager = new OrderManager();
            Naming.rebind("OrderManager", usermanager);
            System.out.println("OrderManager is ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
