package com.lgx.dao;

import com.lgx.model.Resume;
import com.lgx.model.User;

import java.util.List;

public interface ResumeMapper {
    Resume selectResume(int uid);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean updateResumeState(Resume resume);
    List<Resume> selectResumeByState(int i,int j);
    boolean updateResumeState2(Resume resume);
}
