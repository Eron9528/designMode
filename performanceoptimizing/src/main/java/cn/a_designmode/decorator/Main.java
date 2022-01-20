package cn.a_designmode.decorator;

public class Main {
    public static void main(String[] args) {
        IPacketCreator r = new PacketHTMLHeaderCreator(new PocketBodyCreator());
        System.out.println(r.handleContent());
    }
}
