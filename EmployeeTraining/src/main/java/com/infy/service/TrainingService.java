package com.infy.service;

import java.util.List;

import com.infy.dto.TrainingDTO;
import com.infy.entity.Training;
import com.infy.exception.TrainingException;

public interface TrainingService {
	public Training getTraining(Integer empId) throws TrainingException;
	public Integer addTraining(TrainingDTO trainingDTO) throws TrainingException;
//	public void updateTraining(TrainingDTO trainingDTO) throws TrainingException;
//	public Integer deleteTraining(Integer empId) throws TrainingException;

}
