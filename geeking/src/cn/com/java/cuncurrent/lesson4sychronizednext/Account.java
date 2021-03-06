package cn.com.java.cuncurrent.lesson4sychronizednext;

public class Account {
    // 锁 ： 保护账户余额
    private final Object balLock = new Object();
    // 账户余额
    private Integer balance;
    // 锁 ： 保护账户密码
    private final Object pwLock = new Object();
    // 账户密码
    private String password;

    // 取款
    void withdraw(Integer amt){
        synchronized (balLock){
            if (this.balance > amt){
                this.balance -= amt;
            }
        }
    }
    // 查看余额
    Integer getBalance(){
        synchronized (balLock){
            return balance;
        }
    }
    // 更改密码
    void updatePassword(String pw){
        synchronized (pwLock){
            this.password = pw;
        }
    }
    // 查看密码
    String getPassword(){
        synchronized (pwLock){
            return password;
        }
    }

    synchronized void transfer(Account target, int amt){
        if (this.balance > amt){
            this.balance -= amt;
            target.balance += amt;
        }
    }
}
