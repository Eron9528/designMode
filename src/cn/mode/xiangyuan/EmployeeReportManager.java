package cn.mode.xiangyuan;

public class EmployeeReportManager implements IReportManager {   // 员工报表

    protected String tenantId = null;

    public EmployeeReportManager(String tenantId) {     // 租户 ID
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return null;
    }

}
