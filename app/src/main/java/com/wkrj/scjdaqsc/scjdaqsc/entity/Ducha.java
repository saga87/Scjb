package com.wkrj.scjdaqsc.scjdaqsc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fxn on 2017/6/24.
 */

public class Ducha implements Serializable{
    private String tz_fcqk;
    private String tz_checkaddress;
    private String tz_id;
    private String tz_isok;
    private String tz_zgcs;
    private String tz_checkqyname;
    private String tz_tel;
    private String tz_checktime;
    private String tz_state;
    private long tz_type;
    private String tz_isconfirm;
    private String tz_dutyuser;
    private String tz_fctime;
    private String tz_jcdw;
    private long tz_qytype;
    private long enterprise_id;
    private String tz_exitproblem;
    private long input_dept;
    private List<Fcfile> tz_fcfile;
    private List<Filefj> tz_file;
    private String tz_other;

    public List<Fcfile> getTz_fcfile() {
        return tz_fcfile;
    }

    public void setTz_fcfile(List<Fcfile> tz_fcfile) {
        this.tz_fcfile = tz_fcfile;
    }

    public List<Filefj> getTz_file() {
        return tz_file;
    }

    public void setTz_file(List<Filefj> tz_file) {
        this.tz_file = tz_file;
    }

    public String getTz_other() {
        return tz_other;
    }

    public void setTz_other(String tz_other) {
        this.tz_other = tz_other;
    }

    public String getTz_fcqk() {
        return tz_fcqk;
    }

    public void setTz_fcqk(String tz_fcqk) {
        this.tz_fcqk = tz_fcqk;
    }

    public String getTz_checkaddress() {
        return tz_checkaddress;
    }

    public void setTz_checkaddress(String tz_checkaddress) {
        this.tz_checkaddress = tz_checkaddress;
    }

    public String getTz_id() {
        return tz_id;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }

    public String getTz_isok() {
        return tz_isok;
    }

    public void setTz_isok(String tz_isok) {
        this.tz_isok = tz_isok;
    }

    public String getTz_zgcs() {
        return tz_zgcs;
    }

    public void setTz_zgcs(String tz_zgcs) {
        this.tz_zgcs = tz_zgcs;
    }

    public String getTz_checkqyname() {
        return tz_checkqyname;
    }

    public void setTz_checkqyname(String tz_checkqyname) {
        this.tz_checkqyname = tz_checkqyname;
    }

    public String getTz_tel() {
        return tz_tel;
    }

    public void setTz_tel(String tz_tel) {
        this.tz_tel = tz_tel;
    }

    public String getTz_checktime() {
        return tz_checktime;
    }

    public void setTz_checktime(String tz_checktime) {
        this.tz_checktime = tz_checktime;
    }

    public String getTz_state() {
        return tz_state;
    }

    public void setTz_state(String tz_state) {
        this.tz_state = tz_state;
    }

    public long getTz_type() {
        return tz_type;
    }

    public void setTz_type(long tz_type) {
        this.tz_type = tz_type;
    }

    public String getTz_isconfirm() {
        return tz_isconfirm;
    }

    public void setTz_isconfirm(String tz_isconfirm) {
        this.tz_isconfirm = tz_isconfirm;
    }

    public String getTz_dutyuser() {
        return tz_dutyuser;
    }

    public void setTz_dutyuser(String tz_dutyuser) {
        this.tz_dutyuser = tz_dutyuser;
    }

    public String getTz_fctime() {
        return tz_fctime;
    }

    public void setTz_fctime(String tz_fctime) {
        this.tz_fctime = tz_fctime;
    }

    public String getTz_jcdw() {
        return tz_jcdw;
    }

    public void setTz_jcdw(String tz_jcdw) {
        this.tz_jcdw = tz_jcdw;
    }

    public long getTz_qytype() {
        return tz_qytype;
    }

    public void setTz_qytype(long tz_qytype) {
        this.tz_qytype = tz_qytype;
    }

    public long getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getTz_exitproblem() {
        return tz_exitproblem;
    }

    public void setTz_exitproblem(String tz_exitproblem) {
        this.tz_exitproblem = tz_exitproblem;
    }

    public long getInput_dept() {
        return input_dept;
    }

    public void setInput_dept(long input_dept) {
        this.input_dept = input_dept;
    }
}
