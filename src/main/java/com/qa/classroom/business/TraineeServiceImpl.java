package com.qa.classroom.business;

import javax.inject.Inject;

import com.qa.classroom.persistence.domain.Trainee;
import com.qa.classroom.persistence.repository.TraineeRepository;
import com.qa.classroom.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService {

	@Inject private TraineeRepository repo;
	
	@Inject private JSONUtil util;

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	@Override
	public String addTrainee(String traineeData) {
		/*Trainee TraineeObject = util.getObjectForJSON(traineeData, Trainee.class);
		if(TraineeObject.getTraineeID().equals("9")) {
			return "{\"message\": \"This Trainee is blocked\"}";
		}*/
		return repo.createTrainee(traineeData);
	}

	@Override
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}

	@Override
	public String findTrainee(Long id) {
		return repo.findTrainee(id);
	}

	@Override
	public String updateTrainee(Long id, String traineeData) {
		return repo.updateTrainee(id, traineeData);
	}
}
