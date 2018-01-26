package com.lgx.model;

import java.io.Serializable;
import java.util.Date;

public class Dept implements Serializable{
    private int did;
    private String dname;
    private Date createTime;

    public Dept() {
    }

    public Dept(int did, String dname, Date createTime) {
        this.did = did;
        this.dname = dname;
        this.createTime = createTime;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
