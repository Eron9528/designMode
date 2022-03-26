package cn.com.java.cuncurrent.lesson5deadlock;

public class Account {
    /**   会造成死锁     */
//    private int balance;
//    // 转账
//    void transfer(Account target,int amt){
//        // 锁定转出账户
//        synchronized (this){
//            // 锁定转入账户
//            synchronized (target){
//                if (this.balance > amt){
//                    this.balance -= amt;
//                    target.balance += amt;
//                }
//            }
//        }
//    }

    // actr 应该为单例
    private Allocator actr;
    private int balance;
    // 转账
    void transfer(Account target, int amt){
        // 一次性申请转出和转入账户，直到成功
        while(!actr.apply(this, target)){
            ;
        }
        try{
            synchronized (this){
                synchronized (target){
                    if (this.balance > amt){
                        this.balance -= amt;
                        target.balance +=amt;
                    }
                }
            }
        }finally {
            actr.free(this, target);
        }
    }
}
