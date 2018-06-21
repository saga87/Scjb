package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fxn on 2017/6/21.
 */

public class FirmObg implements Serializable {
    private long PageCount;
    private List<FirmList> Rows;
    private String enterpriseOtherInfo;
    private long Total;

    public long getPageCount() {
        return PageCount;
    }

    public void setPageCount(long pageCount) {
        PageCount = pageCount;
    }

    public List<FirmList> getRows() {
        return Rows;
    }

    public void setRows(List<FirmList> rows) {
        Rows = rows;
    }

    public String getEnterpriseOtherInfo() {
        return enterpriseOtherInfo;
    }

    public void setEnterpriseOtherInfo(String enterpriseOtherInfo) {
        this.enterpriseOtherInfo = enterpriseOtherInfo;
    }

    public long getTotal() {
        return Total;
    }

    public void setTotal(long total) {
        Total = total;
    }
}
