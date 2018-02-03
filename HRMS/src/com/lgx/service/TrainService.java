package com.lgx.service;

import com.lgx.model.Train;

import java.util.List;

public interface TrainService {
    List<Train> getAllTrain();
    boolean addTrain(Train train);
    boolean deleteTrain(Train train);
    boolean updateTrain(Train train);
}
