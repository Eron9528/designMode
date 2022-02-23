package cn.com.javasehigh.c_designmode_garbagecollect.a_designmode;

import java.util.ArrayList;
import java.util.List;

public class G_Builder {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(2);
        List<Sender> mailSenders = builder.getList();
        mailSenders.get(0).send();



    }
 }

 class Builder{
     private List<Sender> list = new ArrayList<>();
     public List<Sender> getList(){
         return list;
     }
     public void produceMailSender(int count){
         for (int i = 0; i<count; i++){
             list.add(new MailSender());
         }
     }
     public void produceSmsSender(int count){
         for (int i = 0; i<count; i++){
             list.add(new SmsSender());
         }
     }
 }
