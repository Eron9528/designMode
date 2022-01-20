package cn.iocandaop.ioc;

public class Moattack implements ActorArrangable {

    private GeLi geLi;
//
//    public Moattack(GeLi geLi) {
//        this.geLi = geLi;
//    }

    public void cityGateAsk(){
        // 1. 演员直接侵入剧本
//        GeLi ldh = new LiuDeHua();
//        ldh.responseAsk("墨者隔离！");

        // 构造函数注入
        geLi.responseAsk("墨者隔离！");
    }

    @Override
    public void injectGeli(GeLi geli) {
        this.geLi = geli;
    }
}
