package com.lgx.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
    private int id;
    private String name;
    private String sex;
    private int age;
    private int state;
    private int pid;//对应职位表
    private int uid;//对应游客表
    private int tid;//对应培训表
    private Date createTime;

    public Employee() {
    }

    public Employee(int id, String name, String sex, int age, int state, int pid, int uid, int tid, Date createTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.state = state;
        this.pid = pid;
        this.uid = uid;
        this.tid = tid;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "EmployeeMapper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", state=" + state +
                ", pid=" + pid +
                ", uid=" + uid +
                ", tid=" + tid +
                ", createTime=" + createTime +
                '}';
    }
}
