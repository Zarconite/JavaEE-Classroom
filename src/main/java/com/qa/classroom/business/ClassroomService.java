package com.qa.classroom.business;

public interface ClassroomService {

	String getAllClassrooms();
	String addClassroom(String account);
	String deleteClassroom(Long id);
	String findClassroom(Long id);
	String updateClassroom(Long id, String account);
	
}