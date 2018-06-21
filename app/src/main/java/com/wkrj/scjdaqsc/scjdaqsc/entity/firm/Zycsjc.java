package com.wkrj.scjdaqsc.scjdaqsc.entity.firm;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/21.
 */

public class Zycsjc implements Serializable {
    private long zycsjc_id;
    private String zycsjc_jcbgmc;
    private String zycsjc_jcrq;
    private String zycsjc_yxrq;
    private long enterprise_id;
    private String zycsjc_jcdw;
    private String zycsjc_zysjzywhys;

    public long getZycsjc_id() {
        return zycsjc_id;
    }

    public void setZycsjc_id(long zycsjc_id) {
        this.zycsjc_id = zycsjc_id;
    }

    public String getZycsjc_jcbgmc() {
        return zycsjc_jcbgmc;
    }

    public void setZycsjc_jcbgmc(String zycsjc_jcbgmc) {
        this.zycsjc_jcbgmc = zycsjc_jcbgmc;
    }

    public String getZycsjc_jcrq() {
        return zycsjc_jcrq;
    }

    public void setZycsjc_jcrq(String zycsjc_jcrq) {
        this.zycsjc_jcrq = zycsjc_jcrq;
    }

    public String getZycsjc_yxrq() {
        return zycsjc_yxrq;
    }

    public void setZycsjc_yxrq(String zycsjc_yxrq) {
        this.zycsjc_yxrq = zycsjc_yxrq;
    }

    public long getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getZycsjc_jcdw() {
        return zycsjc_jcdw;
    }

    public void setZycsjc_jcdw(String zycsjc_jcdw) {
        this.zycsjc_jcdw = zycsjc_jcdw;
    }

    public String getZycsjc_zysjzywhys() {
        return zycsjc_zysjzywhys;
    }

    public void setZycsjc_zysjzywhys(String zycsjc_zysjzywhys) {
        this.zycsjc_zysjzywhys = zycsjc_zysjzywhys;
    }
}
