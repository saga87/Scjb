package com.wkrj.scjdaqsc.scjdaqsc.entity.firm;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/21.
 */

public class Aqbzh implements Serializable {
    private String aqbzh_fsrq;
    private String aqbzh_psrq;
    private long aqbzh_id;
    private String aqbzh_zsbh;
    private String aqbzh_aqbzhjb;
    private String aqbzh_aqbzh;
    private long enterprise_id;

    public String getAqbzh_fsrq() {
        return aqbzh_fsrq;
    }

    public void setAqbzh_fsrq(String aqbzh_fsrq) {
        this.aqbzh_fsrq = aqbzh_fsrq;
    }

    public String getAqbzh_psrq() {
        return aqbzh_psrq;
    }

    public void setAqbzh_psrq(String aqbzh_psrq) {
        this.aqbzh_psrq = aqbzh_psrq;
    }

    public long getAqbzh_id() {
        return aqbzh_id;
    }

    public void setAqbzh_id(long aqbzh_id) {
        this.aqbzh_id = aqbzh_id;
    }

    public String getAqbzh_zsbh() {
        return aqbzh_zsbh;
    }

    public void setAqbzh_zsbh(String aqbzh_zsbh) {
        this.aqbzh_zsbh = aqbzh_zsbh;
    }

    public String getAqbzh_aqbzhjb() {
        return aqbzh_aqbzhjb;
    }

    public void setAqbzh_aqbzhjb(String aqbzh_aqbzhjb) {
        this.aqbzh_aqbzhjb = aqbzh_aqbzhjb;
    }

    public String getAqbzh_aqbzh() {
        return aqbzh_aqbzh;
    }

    public void setAqbzh_aqbzh(String aqbzh_aqbzh) {
        this.aqbzh_aqbzh = aqbzh_aqbzh;
    }

    public long getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }
}
