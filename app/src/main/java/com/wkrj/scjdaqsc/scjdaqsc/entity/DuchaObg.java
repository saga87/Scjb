package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.util.List;

/**
 * Created by fxn on 2017/6/24.
 */

public class DuchaObg {
    private long PageCount;
    private List<Ducha> Rows;
    private long Total;

    public long getPageCount() {
        return PageCount;
    }

    public void setPageCount(long pageCount) {
        PageCount = pageCount;
    }

    public List<Ducha> getRows() {
        return Rows;
    }

    public void setRows(List<Ducha> rows) {
        Rows = rows;
    }

    public long getTotal() {
        return Total;
    }

    public void setTotal(long total) {
        Total = total;
    }
}
