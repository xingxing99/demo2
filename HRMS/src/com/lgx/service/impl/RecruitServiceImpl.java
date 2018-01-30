package com.lgx.service.impl;

import com.lgx.dao.RecruitMapper;
import com.lgx.model.Recruit;
import com.lgx.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitMapper recruitMapper;

    @Override
    public List<Recruit> selectRecruit() {
        return recruitMapper.selectRecruit();
    }

    @Override
    public boolean addRecruit(Recruit recruit) {
        try {
            return recruitMapper.addRecruit(recruit);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        try {
            return recruitMapper.updateRecruit(recruit);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Recruit selectRecruitById(int id) {
        return recruitMapper.selectRecruitById(id);
    }
}
