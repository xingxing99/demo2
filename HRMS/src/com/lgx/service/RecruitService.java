package com.lgx.service;

import com.lgx.model.Recruit;

import java.util.List;

public interface RecruitService {
    List<Recruit> selectRecruit();
    boolean addRecruit(Recruit recruit);
    boolean updateRecruit(Recruit recruit);
    Recruit selectRecruitById(int id);
    List<Recruit> selectRecruitByState(int state);
}
