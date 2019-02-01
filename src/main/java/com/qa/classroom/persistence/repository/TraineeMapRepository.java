package com.qa.classroom.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.classroom.persistence.domain.Trainee;
import com.qa.classroom.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository{
	
	Map<Long, Trainee> traineeMap = new HashMap<>();
	
	@Inject private JSONUtil util;
	
	public String getAllTrainees() {
		return util.getJSONForObject(traineeMap);
	}
	
	public String createTrainee(String traineeData) {
		Trainee newAccount = util.getObjectForJSON(traineeData, Trainee.class);
		traineeMap.put(newAccount.getTraineeID(), newAccount);
		return "Created new trainee with info: Name: " + newAccount.getTraineeName()+".";
	}

	public String deleteTrainee(Long id) {
		traineeMap.remove(id);
		return "Deleted trainee with id: " +id+".";
	}
	
	public String updateTrainee(Long id, String traineeData) {
		Trainee updTrainee = util.getObjectForJSON(traineeData, Trainee.class);
		traineeMap.replace(id, traineeMap.get(id), updTrainee);
		return "Updated Account: "+id+" with new data.";
	}
	
	public String findTrainee(Long id) {
		return util.getJSONForObject(traineeMap.get(id));
	}

}
