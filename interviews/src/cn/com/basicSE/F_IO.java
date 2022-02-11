package cn.com.basicSE;

public class F_IO {
    public static void main(String[] args) {


        // 1. Java中有几种类型的流
        /**
         *   按照流的方向：输入流（inputStream）和输出流（outputStream）。
         *
         *   按照实现功能分：节点流（可以从或向一个特定的地方（节点）读写数据。如FileReader）和
         *                处理流（是对一个已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写。如BufferedReader。
         *              处理流的构造方法总是要带一个其他的流对象做参数。一个流对象经过其他流的多次包装，称为流的链接。）
         *
         *   按照处理数据的单位：字节流和字符流。字节流继承于InputStream和OutputStream，字符流继承于InputStreamReader
         *                  和OutputStreamWriter。
         */


        // 2. 字节流如何转为字符流

        System.out.println("=============题目1===============");

    }
}
