package com.wkrj.scjdaqsc.scjdaqsc.entity.firm;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/21.
 */

public class Wxhxpdj implements Serializable{
    private String wxhxpdj_yxrq;
    private String wxhxpdj_djrq;
    private long  wxhxpdj_id;
    private String wxhxpdj_djwxhxpmc;
    private long enterprise_id;
    private String wxhxpdj_zsbh;

    public String getWxhxpdj_yxrq() {
        return wxhxpdj_yxrq;
    }

    public void setWxhxpdj_yxrq(String wxhxpdj_yxrq) {
        this.wxhxpdj_yxrq = wxhxpdj_yxrq;
    }

    public String getWxhxpdj_djrq() {
        return wxhxpdj_djrq;
    }

    public void setWxhxpdj_djrq(String wxhxpdj_djrq) {
        this.wxhxpdj_djrq = wxhxpdj_djrq;
    }

    public long getWxhxpdj_id() {
        return wxhxpdj_id;
    }

    public void setWxhxpdj_id(long wxhxpdj_id) {
        this.wxhxpdj_id = wxhxpdj_id;
    }

    public String getWxhxpdj_djwxhxpmc() {
        return wxhxpdj_djwxhxpmc;
    }

    public void setWxhxpdj_djwxhxpmc(String wxhxpdj_djwxhxpmc) {
        this.wxhxpdj_djwxhxpmc = wxhxpdj_djwxhxpmc;
    }

    public long getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getWxhxpdj_zsbh() {
        return wxhxpdj_zsbh;
    }

    public void setWxhxpdj_zsbh(String wxhxpdj_zsbh) {
        this.wxhxpdj_zsbh = wxhxpdj_zsbh;
    }
}
