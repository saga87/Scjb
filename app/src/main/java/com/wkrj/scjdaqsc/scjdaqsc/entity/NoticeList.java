package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fxn on 2017/6/20.
 */

public class NoticeList implements Serializable {
    private int PageCount;
    private List<Notice> Rows;
    private int Total;

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public List<Notice> getRows() {
        return Rows;
    }

    public void setRows(List<Notice> rows) {
        Rows = rows;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
