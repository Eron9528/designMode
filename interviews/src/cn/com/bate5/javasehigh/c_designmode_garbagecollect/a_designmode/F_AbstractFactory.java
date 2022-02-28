package cn.com.bate5.javasehigh.c_designmode_garbagecollect.a_designmode;

public class F_AbstractFactory {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender provide = provider.provide();
        provide.send();
    }
}

interface Provider{
    public Sender provide();
}

class SendSmsFactory implements Provider{
    @Override
    public Sender provide() {
        return new SmsSender();
    }
}

class SendMailFactory implements Provider{
    @Override
    public Sender provide() {
        return new MailSender();
    }
}
