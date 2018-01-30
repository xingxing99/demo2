package com.lgx.model;

import java.io.Serializable;

public class Post implements Serializable {
    private int id;
    private String name;//职位名称
    private int did;//对应部门
    private String description;//描述

    public Post() {
    }

    public Post(int id, String name, int did, String description) {
        this.id = id;
        this.name = name;
        this.did = did;
        this.description = description;
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

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", did=" + did +
                ", description='" + description + '\'' +
                '}';
    }
}
