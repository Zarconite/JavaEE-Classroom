package com.qa.classroom.business;

import javax.inject.Inject;

import com.qa.classroom.persistence.domain.Classroom;
import com.qa.classroom.persistence.repository.ClassroomRepository;
import com.qa.classroom.util.JSONUtil;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject private ClassroomRepository repo;
	
	@Inject private JSONUtil util;

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String addClassroom(String classroom) {
		/*Classroom classroomObject = util.getObjectForJSON(classroom, Classroom.class);
		if(classroomObject.getClassroomID().equals("9")) {
			return "{\"message\": \"This classroom is blocked\"}";
		}*/
		return repo.createClassroom(classroom);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

	@Override
	public String findClassroom(Long id) {
		return repo.findClassroom(id);
	}

	@Override
	public String updateClassroom(Long id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}
}
