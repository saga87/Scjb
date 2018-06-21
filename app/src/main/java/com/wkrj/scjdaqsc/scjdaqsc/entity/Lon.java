package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/29.
 */

public class Lon implements Serializable{
    private long dept_id;
    private long user_id;
    private String enterprise_id;

    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }
}
