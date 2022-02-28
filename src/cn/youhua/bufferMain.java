package cn.youhua;

import java.io.*;

public class bufferMain {
    private static final int CIRCLE = 600000;
    public static void main(String[] args) {
        // 缓冲最常用的场景就是提高 I/O 的速度。为此，JDK 内不少 I/O 组件都提供了缓冲功能。比如，当
        // 使用 FileWriter 时， 进行文件写操作的代码如下：
        Writer writer;
        {
            try {
             //   writer = new BufferedWriter(new FileWriter(new File("file.txt")));
                writer = new FileWriter(new File("file.txt"));
                long begin = System.currentTimeMillis();
                for (int i = 0; i < CIRCLE; i++){
                    writer.write(i);
                }
                writer.close();
                System.out.println("textFileWriter spend: " + (System.currentTimeMillis() -begin));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
