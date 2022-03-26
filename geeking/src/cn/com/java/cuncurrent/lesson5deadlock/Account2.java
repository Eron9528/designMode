package cn.com.java.cuncurrent.lesson5deadlock;

public class Account2 {

    /** Account 是破坏抢占条件 */
    /** Account2 是破坏循环条件 */
    private int id;
    private int balance;
    // 转账
    void transfer(Account2 target, int amt){
        Account2 left = this;
        Account2 rigth = target;
        if (left.id > rigth.id){
            left = target;
            rigth = this;
        }
        // 锁定序号小的
        synchronized (left){
            synchronized (rigth){
                if (this.balance > amt){
                    this.balance -= amt;
                    target.balance +=amt;
                }
            }
        }
    }
}
