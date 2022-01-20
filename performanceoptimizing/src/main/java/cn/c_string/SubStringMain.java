package cn.c_string;

import java.util.ArrayList;
import java.util.List;

public class SubStringMain {
    public static void main(String[] args) {

        // subString 容易导致内存泄漏

        List<String> handler = new ArrayList<String>();

        /** HugeStr 不到1000 次就内存溢出 ， 但是 ImprovedHuge */
        for (int i = 0; i < 1000; i++){

        }
    }

    static class HugeStr{
        private String str = new String(new char[100000]); //十万个字符长度，一个很长的 String;
        public String getSubString(int begin, int end){ // 截取字符串， 有溢出
            return str.substring(begin,end);
        }
    }
}
