package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/26.
 */

public class FirmType implements Serializable{
   private String type_name;
    private long  type_id;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }
}
