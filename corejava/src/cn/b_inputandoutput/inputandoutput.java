package cn.b_inputandoutput;

import sun.text.normalizer.UTF16;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class inputandoutput {

    public static void main(String[] args) throws IOException {
        InputStream is = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        is.available();   // 判断是否可以进行读写，返回可以读的字节数
        is.close();
        System.out.println(System.getProperty("user.dir"));
        ;

        // FileInputStream 只支持字节上的读写
        FileInputStream fin = new FileInputStream("C:\\Users\\Maero\\Desktop\\新建文本文档 (4).txt");
        byte by = (byte) fin.read();
        System.out.println(by);

        // DateInputStream
        DataInputStream dis = new DataInputStream(fin);
        byte x = dis.readByte();
        System.out.println(x);

        // 单个读取会增加系统不必要的开销，加入缓存
        DataInputStream dis2 = new DataInputStream(
                        new BufferedInputStream(
                        new FileInputStream("C:\\Users\\Maero\\Desktop\\新建文本文档 (4).txt")));

        // 预览下一个字节
        PushbackInputStream pis = new PushbackInputStream(
                new FileInputStream("C:\\Users\\Maero\\Desktop\\新建文本文档 (4).txt"));

        byte b = (byte) pis.read();

        System.out.println(b);
        pis.unread(b);// 如果不是自己想要的直接回退
        b = (byte) pis.read();
        System.out.println(b);

        // 如何读入文本输入
        String str = new String(Files.readAllBytes(Paths.get("C:\\Users\\Maero\\Desktop\\新建文本文档 (4).txt")), StandardCharsets.UTF_8);
        // 一行一行的读取
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Maero\\Desktop\\新建文本文档 (4).txt"), StandardCharsets.UTF_8);





    }
}
