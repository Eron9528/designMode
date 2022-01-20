package cn.mode.proxy;

public class Main {
    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy();
        q.request();   // 在真正使用的时候才创建真实的对象。
    }

    // 将代理模式用于实现延迟加载，可以有效的提升系统的启动速度，对改善用户体验有很大的帮助
}
