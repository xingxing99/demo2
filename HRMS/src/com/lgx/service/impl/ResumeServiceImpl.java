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
    public List<Resume> selectResume(int uid) {
        return resumeMapper.selectResume(uid);
    }
}