package cn.a_designmode.flyweight;

public class FinancialReportManager implements IReportManager{

    protected String tenantId = null;
    public FinancialReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report";
    }
}
