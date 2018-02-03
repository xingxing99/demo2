package com.lgx.dao;

import com.lgx.model.Train;

import java.util.List;

public interface TrainMapper {
    List<Train> getAllTrain();
    boolean addTrain(Train train);
    boolean deleteTrain(Train train);
    boolean updateTrain(Train train);
}
