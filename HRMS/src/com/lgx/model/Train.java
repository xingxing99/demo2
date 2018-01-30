package com.lgx.model;

import java.io.Serializable;

public class Train implements Serializable{
    private int id;
    private String beginTime;
    private String endTime;
    private String name;
    private int state;
    private String content;
    private int eid;

    public Train() {
    }

    public Train(int id, String beginTime, String endTime, String name, int state, String content, int eid) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.name = name;
        this.state = state;
        this.content = content;
        this.eid = eid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", content='" + content + '\'' +
                ", eid=" + eid +
                '}';
    }
}
