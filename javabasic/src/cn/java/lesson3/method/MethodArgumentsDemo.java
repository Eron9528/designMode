package cn.java.lesson3.method;

public class MethodArgumentsDemo implements Comparable<MethodArgumentsDemo> {
    public static void main(String[] args) {
        // arguments 通常形容方法参数
        // parameters 通常是指外部媒介传递过来，请求参数

    }

    private int value;

    // 方法参数名称设计
    public boolean equals(Object that){
        return this.value == ((MethodArgumentsDemo)that).value;
    }

    @Override
    public int compareTo(MethodArgumentsDemo another) {
        return 0;
    }
}
