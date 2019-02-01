package com.qa.classroom.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Trainee")
@Table(name = "Trainee")
public class Classroom {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomID;
	@Column private String trainer;
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	    private List<Trainee> trainees = new ArrayList<>();
	
	public Classroom() {

	}

	public Classroom(String trainer, List<Trainee> trainees) {
		this.trainer = trainer;
		this.trainees = trainees;
	}

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

}
