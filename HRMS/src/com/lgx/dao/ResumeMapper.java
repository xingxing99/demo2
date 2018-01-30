package com.lgx.dao;

import com.lgx.model.Resume;
import com.lgx.model.User;

import java.util.List;

public interface ResumeMapper {
    Resume selectResume(int uid);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean updateResumeState(Resume resume);
    Resume selectResumeByState(Resume resume);
    boolean updateResumeState2(Resume resume);
}
