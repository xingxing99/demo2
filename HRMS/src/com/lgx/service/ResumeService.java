package com.lgx.service;

import com.lgx.model.Resume;
import com.lgx.model.User;

import java.util.List;

public interface ResumeService {
    Resume selectResume(int uid);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean updateResumeState(Resume resume);
    List<Resume> selectResumeByState(int i,int j);
    boolean updateResumeState2(Resume resume);
}
