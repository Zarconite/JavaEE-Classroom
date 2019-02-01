package com.qa.classroom.persistence.repository;

public interface ClassroomRepository {

	String getAllClassrooms();
	String createClassroom(String trainer);
	String deleteClassroom(Long classroomID);
	String updateClassroom(Long classroomID, String trainer);
	String findClassroom(Long classroomID);

}
