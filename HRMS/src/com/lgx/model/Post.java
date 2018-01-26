package com.lgx.model;

import java.io.Serializable;

public class Post implements Serializable {
    private int id;
    private String name;//职位名称
    private Dept dept;//对应部门
    private String describe;//描述

    public Post() {
    }

    public Post(int id, String name, Dept dept, String describe) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.describe = describe;
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                ", describe='" + describe + '\'' +
                '}';
    }
}
