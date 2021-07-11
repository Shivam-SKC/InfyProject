package com.infy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.TrainingDTO;
import com.infy.entity.Training;
import com.infy.exception.TrainingException;
import com.infy.service.TrainingServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/training")
public class TrainingController {

	@Autowired
	private TrainingServiceImpl trainingService;
	
	@GetMapping("/{empId}")
	public ResponseEntity<Training> getTraining(@PathVariable Integer empId) throws TrainingException{
	
		return new ResponseEntity<>(trainingService.getTraining(empId),HttpStatus.OK);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addTraining(@RequestBody TrainingDTO trainingDTO) throws TrainingException{
		Integer tId=trainingService.addTraining(trainingDTO);
	
		String success="Training is Successfully Added with training id "+tId;
		return new ResponseEntity<>(success,HttpStatus.CREATED);
	}
}







