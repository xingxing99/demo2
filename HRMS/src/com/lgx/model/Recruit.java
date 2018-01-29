package com.lgx.model;

import java.io.Serializable;
import java.util.Date;

public class Recruit implements Serializable {
    private int id;
    private int pid;//对应职位表
    private String requirement;//需求
    private String salaryRange;//薪资
    private String address;//地址
    private int state;
    private Date createTime;
    private String introduction;//公司简介

    public Recruit() {
    }

    public Recruit(int id, int pid, String requirement, String salaryRange, String address, int state, Date createTime, String introduction) {
        this.id = id;
        this.pid = pid;
        this.requirement = requirement;
        this.salaryRange = salaryRange;
        this.address = address;
        this.state = state;
        this.createTime = createTime;
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", pid=" + pid +
                ", requirement='" + requirement + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
