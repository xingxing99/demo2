package com.lgx.dao;

import com.lgx.model.Resume;
import com.lgx.model.User;

import java.util.List;

public interface ResumeMapper {
    List<Resume> selectResume(int uid);
    boolean addResume(Resume resume);
}
