package cn.com.bate5.javasehigh.c_designmode_garbagecollect.a_designmode;

public class K_Strategy {
    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int calculate = cal.calculate(exp);
        System.out.println(calculate);
    }
}

interface ICalculator {
    public int calculate(String exp);
}

class AbstractCalculate{
    public int[] split(String exp, String opt){
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}

class Minus extends AbstractCalculate implements ICalculator{

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "-");
        return arrayInt[0]-arrayInt[1];
    }
}

class Plus extends AbstractCalculate implements ICalculator{

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "\\+");
        return arrayInt[0]+arrayInt[1];
    }
}