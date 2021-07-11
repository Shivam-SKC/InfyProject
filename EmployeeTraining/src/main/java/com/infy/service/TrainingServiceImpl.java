package com.infy.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.TrainingDTO;
import com.infy.entity.Training;
import com.infy.exception.TrainingException;
import com.infy.repository.TrainingRepository;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService{
	
	@Autowired
	private TrainingRepository repo;
	
	@Autowired
	private Environment env;
	
	@Override
	public Integer addTraining(TrainingDTO trainingDTO) throws TrainingException{
		Training tr=repo.findByEmpId(trainingDTO.getEmpId());
		if(tr!=null) {
			throw new TrainingException("TRAINING_ALREADY_EXIST");
		}
		
		Training t=new Training();
		t.setCode(trainingDTO.getCode());
		t.setCourse(trainingDTO.getCourse());
		t.setDateCompleted(trainingDTO.getDateCompleted());
		t.setEmpId(trainingDTO.getEmpId());
		t.setHoursSpent(trainingDTO.getHoursSpent());
		t.setScore(trainingDTO.getScore());
		t.setStatus(trainingDTO.getStatus());
		
		repo.save(t);
		
		return t.gettId();
		
	}
	 
	@Override
	public Training getTraining(Integer empId) throws TrainingException {
		Training training=repo.findByEmpId(empId);
		if(training==null) {
			throw new TrainingException("TRAINING_NOT_FOUND");
		}
		return training;

	}

}
