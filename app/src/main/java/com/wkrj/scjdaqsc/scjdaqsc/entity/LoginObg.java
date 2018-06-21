package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fxn on 2017/6/29.
 */

public class LoginObg implements Serializable{
    private boolean success;
    private String msg;
    private Lon obj;
    private String attributes;
    private String jsonStr;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Lon getObj() {
        return obj;
    }

    public void setObj(Lon obj) {
        this.obj = obj;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }
}
