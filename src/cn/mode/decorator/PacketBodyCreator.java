package cn.mode.decorator;

/**
 * 具体的组件，他的功能是构造要发布信息的核心内容，但是它不负责将其构造成一个格式工整、可直接发布的数据格式。
 */
public class PacketBodyCreator implements IPacketCreator{

    @Override
    public String handleContent() {
        return "Content of Packet";      // 构造核心数据，但不包括格式
    }
}
