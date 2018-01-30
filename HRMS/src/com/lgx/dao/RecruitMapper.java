package com.lgx.dao;

import com.lgx.model.Recruit;

import java.util.List;

public interface RecruitMapper {
    List<Recruit> selectRecruit();
    boolean addRecruit(Recruit recruit);
    boolean updateRecruit(Recruit recruit);
    Recruit selectRecruitById(int id);
    List<Recruit> selectRecruitByState(int state);
}
