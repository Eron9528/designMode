package cn.iocandaop.ioc;

public class Director {
    public void direct(){
        GeLi geli = new LiuDeHua();
        Moattack moattack  = new Moattack();
        moattack.injectGeli(geli);
        moattack.cityGateAsk();
    }

}
