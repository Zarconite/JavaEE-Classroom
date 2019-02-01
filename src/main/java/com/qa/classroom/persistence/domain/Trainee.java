package com.qa.classroom.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Trainee")
@Table(name = "Trainee")
public class Trainee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traineeID;
	
	@Column private Long classroomID;
	
	@Column private String traineeName;
	
	public Trainee() {

	}
	
	public Trainee(String traineeName,Long classroomID) {
		this.traineeName = traineeName;
		this.classroomID = classroomID;
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

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

}
