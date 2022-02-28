package cn.com.bate5.javasehigh.c_designmode_garbagecollect.a_designmode;

public class E_StaticFactory {
    public static void main(String[] args) {
        SendStaticMultiFactory.produceMail();
    }

}
class SendStaticMultiFactory{
    public static Sender produceMail(){
        return new MailSender();
    }
    public static Sender produceSms(){
        return new SmsSender();
    }

}

