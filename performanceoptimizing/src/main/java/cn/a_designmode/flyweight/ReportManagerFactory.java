package cn.a_designmode.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {
    Map<String, IReportManager> fin = new HashMap<>();
    Map<String, IReportManager> emp = new HashMap<>();

    IReportManager getFin(String tenantId){
        IReportManager r = fin.get(tenantId);
        if (r == null){
            r = new FinancialReportManager(tenantId);
            fin.put(tenantId, r);
        }
        return r;
    }

    IReportManager getEmp(String tenantId){
        IReportManager r = emp.get(tenantId);
        if (r == null){
            r = new EmployeeReportManager(tenantId);
            fin.put(tenantId, r);
        }
        return r;

    }
}
