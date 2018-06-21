package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/30.
 */

public class Filefj implements Serializable{
    private String id;
    private String name;
    private String pdfname;

    public String getPdfname() {
        return pdfname;
    }

    public void setPdfname(String pdfname) {
        this.pdfname = pdfname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
