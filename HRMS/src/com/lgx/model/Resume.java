package com.lgx.model;

import java.io.Serializable;
import java.util.Date;

public class Resume implements Serializable {
    private int id;
    private int uid;
    private String major;//专业
    private String school;//学校
    private String education;//学历
    private String address;//地址
    private String experience;//工作经历
    private String skill;//技能
    private String evaluate;//自我评价
    private Date createTime;
    private int state;//简历状态
    private String degree;//学位

    public Resume() {
    }

    public Resume(int id, int uid, String major, String school, String education, String address, String experience, String skill, String evaluate, Date createTime, int state, String degree) {
        this.id = id;
        this.uid = uid;
        this.major = major;
        this.school = school;
        this.education = education;
        this.address = address;
        this.experience = experience;
        this.skill = skill;
        this.evaluate = evaluate;
        this.createTime = createTime;
        this.state = state;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", uid=" + uid +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", address='" + address + '\'' +
                ", experience='" + experience + '\'' +
                ", skill='" + skill + '\'' +
                ", evaluate='" + evaluate + '\'' +
                ", createTime=" + createTime +
                ", state=" + state +
                ", degree='" + degree + '\'' +
                '}';
    }
}
