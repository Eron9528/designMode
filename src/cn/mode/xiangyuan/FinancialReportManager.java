package cn.mode.xiangyuan;

public class FinancialReportManager implements IReportManager {    // 财务报表

    protected String tenantId = null;

    public FinancialReportManager(String tenantId) {     // 租户 ID
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report";
    }

}
