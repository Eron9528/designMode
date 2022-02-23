package cn.com.javasehigh.c_designmode_garbagecollect.a_designmode;


/**
 *      该模式是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而
 *      多个工厂方法模式是提供多个工厂方法，分别创建对象。
 */
public class D_MultiFactory {
    public static void main(String[] args) {
        SendMultiFactory factory = new SendMultiFactory();
        factory.produceMail();
        factory.produceSms();
    }


}

class SendMultiFactory{
    public Sender produceMail(){
        return new MailSender();
    }
    public Sender produceSms(){
        return new SmsSender();
    }

}
