package com.qa.classroom.persistence.repository;

public interface TraineeRepository {

	String getAllTrainees();
	String createTrainee(String traineeName);
	String deleteTrainee(Long id);
	String updateTrainee(Long id, String traineeName);
	String findTrainee(Long id);
}
