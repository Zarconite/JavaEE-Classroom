package com.qa.classroom.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Classroom")
@Table(name = "Classroom")
public class Trainee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traineeID;
	@Column private String traineeName;
	
	public Trainee() {

	}
	
	public Trainee(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}

}
