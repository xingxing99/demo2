package com.lgx.service;

import com.lgx.model.Resume;
import com.lgx.model.User;

import java.util.List;

public interface ResumeService {
    List<Resume> selectResume(int uid);
}
