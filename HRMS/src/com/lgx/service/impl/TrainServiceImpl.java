package com.lgx.service.impl;

import com.lgx.dao.TrainMapper;
import com.lgx.model.Train;
import com.lgx.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("trainService")
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;

    @Override
    public List<Train> getAllTrain() {
        return trainMapper.getAllTrain();
    }

    @Override
    public boolean addTrain(Train train) {
        return trainMapper.addTrain(train);
    }

    @Override
    public boolean deleteTrain(Train train) {
        try {
            return trainMapper.deleteTrain(train);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateTrain(Train train) {
        try {
            return trainMapper.updateTrain(train);
        } catch (Exception e) {
            return false;
        }
    }
}
