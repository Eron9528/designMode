package cn.com.bate5.javasehigh.c_designmode_garbagecollect.a_designmode;

/**
 *      普通工厂模式
 */
public class C_NormalFactory {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.send();

    }

}

interface Sender{
    void send();
}

class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is sms sender");
    }
}

class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mail sender");
    }
}

class SendFactory{
    public Sender produce(String type){
        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        } else{
            System.out.println("请输入正确的类型！");
            return null;
        }
    }
}
