package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/20.
 */

public class BaoGuang implements Serializable {
    private String bgt_qy;
    private String bgt_type;
    private String bgt_inputuser;
    private String bgt_enterprisename;
    private String bgt_content;
    private String bgt_checktime;
    private String bgt_title;

    public String getBgt_qy() {
        return bgt_qy;
    }

    public void setBgt_qy(String bgt_qy) {
        this.bgt_qy = bgt_qy;
    }

    public String getBgt_type() {
        return bgt_type;
    }

    public void setBgt_type(String bgt_type) {
        this.bgt_type = bgt_type;
    }

    public String getBgt_inputuser() {
        return bgt_inputuser;
    }

    public void setBgt_inputuser(String bgt_inputuser) {
        this.bgt_inputuser = bgt_inputuser;
    }

    public String getBgt_enterprisename() {
        return bgt_enterprisename;
    }

    public void setBgt_enterprisename(String bgt_enterprisename) {
        this.bgt_enterprisename = bgt_enterprisename;
    }

    public String getBgt_content() {
        return bgt_content;
    }

    public void setBgt_content(String bgt_content) {
        this.bgt_content = bgt_content;
    }

    public String getBgt_checktime() {
        return bgt_checktime;
    }

    public void setBgt_checktime(String bgt_checktime) {
        this.bgt_checktime = bgt_checktime;
    }

    public String getBgt_title() {
        return bgt_title;
    }

    public void setBgt_title(String bgt_title) {
        this.bgt_title = bgt_title;
    }
}
