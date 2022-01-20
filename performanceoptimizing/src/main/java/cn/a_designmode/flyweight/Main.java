package cn.a_designmode.flyweight;

public class Main {
    public static void main(String[] args) {
        ReportManagerFactory rmf = new ReportManagerFactory();
        IReportManager a = rmf.getEmp("A");
        System.out.println(a.createReport());
    }
}

