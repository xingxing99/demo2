package com.lgx.service.impl;

import com.lgx.dao.ResumeMapper;
import com.lgx.model.Resume;
import com.lgx.model.User;
import com.lgx.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public Resume selectResume(int uid) {
        return resumeMapper.selectResume(uid);
    }

    @Override
    public boolean addResume(Resume resume) {
        try {
            return resumeMapper.addResume(resume);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateResume(Resume resume) {
        try {
            return resumeMapper.updateResume(resume);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateResumeState(Resume resume) {
        try {
            return resumeMapper.updateResumeState(resume);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Resume> selectResumeByState(int i,int j) {
        return resumeMapper.selectResumeByState(i, j);
    }

    @Override
    public boolean updateResumeState2(Resume resume) {
        try {
            return resumeMapper.updateResumeState2(resume);
        } catch (Exception e) {
            return false;
        }
    }
}
