package com.lgx.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
    private int id;
    private int empNo;
    private Dept dept;
    private int state;
    private User user;
    private Date createTime;

    public Employee() {
    }

    public Employee(int id, int empNo, Dept dept, int state, User user, Date createTime) {
        this.id = id;
        this.empNo = empNo;
        this.dept = dept;
        this.state = state;
        this.user = user;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }



    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empNo=" + empNo +
                ", dept=" + dept +
                ", state=" + state +
                ", user=" + user +
                ", createTime=" + createTime +
                '}';
    }
}
