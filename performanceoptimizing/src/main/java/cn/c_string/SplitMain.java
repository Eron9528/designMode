package cn.c_string;

import java.util.StringTokenizer;

public class SplitMain {

    public static void main(String[] args) {
        String orgStr = null;
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 1000; i++){
            buffer.append(i);
            buffer.append(";");
        }
        orgStr = buffer.toString();


        //
        StringTokenizer tokenizer = new StringTokenizer(orgStr,";");
        for (int i = 0; i < 1000; i++){
            while (tokenizer.hasMoreTokens()){
                String s = tokenizer.nextToken();
            }
            tokenizer  = new StringTokenizer(orgStr,";");
        }

    }


}
