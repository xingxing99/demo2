package com.lgx.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
    private int id;
    private int pid;
    private int state;
    private int uid;
    private Date createTime;

    public Employee() {
    }

    public Employee(int id, int pid, int state, int uid, Date createTime) {
        this.id = id;
        this.pid = pid;
        this.state = state;
        this.uid = uid;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", pid=" + pid +
                ", state=" + state +
                ", uid=" + uid +
                ", createTime=" + createTime +
                '}';
    }
}
