package com.qa.classroom.business;

public interface TraineeService {

	String getAllTrainees();
	String addTrainee(String account);
	String deleteTrainee(Long id);
	String findTrainee(Long id);
	String updateTrainee(Long id, String account);
	
}