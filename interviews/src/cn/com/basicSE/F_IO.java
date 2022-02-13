package cn.com.basicSE;

import java.io.*;

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
        /**
         *      字节输入流转字符输入流通过 InputStreamReader 实现，该类的构造函数可以传入 InputStream 对象。
         *      字节输出流转字符输出流通过 OutputStreamWriter 实现，该类的构造函数可以传入 OutputStream 对象。
         */


        // 3. 如何将一个 java 对象序列化到文件里
        /**
         *      在 java 中能够被序列化的类必须先实现 Serializable 接口，该接口没有任何抽象方法只是起到一个标记作用。
         */


        // 4. 字节流和字符流的区别
        /**
         *      字节流读取的时候，读到一个字节就返回一个字节； 字符流使用了字节流读到一个或多个字节（中文对应的字节
         * 数是两个，在 UTF-8 码表中是 3 个字节）时。先去查指定的编码表，将查到的字符返回。 字节流可以处理所有类型数
         * 据，如：图片，MP3，AVI 视频文件，而字符流只能处理字符数据。只要是处理纯文本数据，就要优先考虑使用字符
         * 流，除此之外都用字节流。字节流主要是操作 byte 类型数据，以 byte 数组为准，主要操作类就是 OutputStream、
         * InputStream
         *
         *      字符流处理的单元为 2 个字节的 Unicode 字符，分别操作字符、字符数组或字符串，而字节流处理单元为 1 个字
         * 节，操作字节和字节数组。所以字符流是由 Java 虚拟机将字节转化为 2 个字节的 Unicode 字符为单位的字符而成的，
         * 所以它对多国语言支持性比较好！如果是音频文件、图片、歌曲，就用字节流好点，如果是关系到中文（文本）的，用
         * 字符流好点。在程序中一个字符等于两个字节，java 提供了 Reader、Writer 两个专门操作字符流的类。
         */


        // 5. 如何实现对象克隆
        /**
         *      有两种方式。
         *      实现 Cloneable 接口并重写 Object 类中的 clone()方法；
         *      实现 Serializable 接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆
         *
         *
         *      注意：基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对
         * 象是否支持序列化，这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用 Object 类的 clone
         * 方法克隆对象。让问题在编译的时候暴露出来总是好过把问题留到运行时。
         */
        System.out.println("=============题目1===============");

    }


}

class MyUtil{
    private MyUtil(){
        throw new AssertionError();
    }

    public static <T extends Serializable> T clone(T obj) throws Exception {

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T)ois.readObject();
    }
}




