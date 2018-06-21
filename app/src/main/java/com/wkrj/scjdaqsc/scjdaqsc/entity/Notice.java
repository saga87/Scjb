package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;

/**
 * Created by fxn on 2017/6/20.
 */

public class Notice implements Serializable {
    private String notice_inputtime;
    private String user_name;
    private String notice_title;
    private String notice_content;
    private String notice_ispublic;
    private String notice_file;
    private String notice_publictime;
    private Long notice_id;
    private Long input_user;
    private Long input_dept;

    public String getNotice_inputtime() {
        return notice_inputtime;
    }

    public void setNotice_inputtime(String notice_inputtime) {
        this.notice_inputtime = notice_inputtime;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_ispublic() {
        return notice_ispublic;
    }

    public void setNotice_ispublic(String notice_ispublic) {
        this.notice_ispublic = notice_ispublic;
    }

    public String getNotice_file() {
        return notice_file;
    }

    public void setNotice_file(String notice_file) {
        this.notice_file = notice_file;
    }

    public String getNotice_publictime() {
        return notice_publictime;
    }

    public void setNotice_publictime(String notice_publictime) {
        this.notice_publictime = notice_publictime;
    }

    public Long getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Long notice_id) {
        this.notice_id = notice_id;
    }

    public Long getInput_user() {
        return input_user;
    }

    public void setInput_user(Long input_user) {
        this.input_user = input_user;
    }

    public Long getInput_dept() {
        return input_dept;
    }

    public void setInput_dept(Long input_dept) {
        this.input_dept = input_dept;
    }
}
