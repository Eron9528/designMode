package cn.a_designmode.valueobject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BusinessDelegate {
    IOrderManager usermanager = null;
    public BusinessDelegate(){
        try {
            usermanager = (IOrderManager) Naming.lookup("OrderManager");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
    public boolean checkUserFromCache(int uid){
        return true;
    }



}
