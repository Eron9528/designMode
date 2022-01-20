package cn.a_designmode.decorator;

public class PocketBodyCreator implements IPacketCreator{
    @Override
    public String handleContent() {
        return "Content of Packet";
    }
}
