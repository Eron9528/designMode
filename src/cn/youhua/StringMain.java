package cn.youhua;

public class StringMain {

    /**
     *  String 对象及其特点
     *  1. 不变性
     *  2. 针对常量池的优化
     *  3. 类的final 定义
     *
     *  
     *
     * @param args
     */

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        System.out.println(str1 == str3);

    }

}
