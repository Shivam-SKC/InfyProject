package com.infy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Training;

public interface TrainingRepository extends JpaRepository<Training,Integer>{
	Training findByEmpId(Integer empId);

}
