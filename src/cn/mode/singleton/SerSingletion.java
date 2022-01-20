package cn.mode.singleton;

public class SerSingletion implements java.io.Serializable{

    String name;

    private SerSingletion() {
        System.out.println("Singleton is create");
        name = "Singleton";
    }

    private static SerSingletion  instance = new SerSingletion();
    public static SerSingletion getInstance(){
        return  instance;
    }


}
