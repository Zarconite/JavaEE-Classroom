package com.qa.classroom.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.classroom.persistence.domain.Classroom;
import com.qa.classroom.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository{
	
	Map<Long, Classroom> accountMap = new HashMap<>();
	
	@Inject private JSONUtil util;
	
	public String getAllClassrooms() {
		return util.getJSONForObject(accountMap);
	}
	
	public String createClassroom(String accountData) {
		Classroom newAccount = util.getObjectForJSON(accountData, Classroom.class);
		accountMap.put(newAccount.getClassroomID(), newAccount);
		return "Created new Classroom with ID: " + newAccount.getClassroomID() + ".";
	}

	public String deleteClassroom(Long id) {
		accountMap.remove(id);
		return "Deleted Classroom with ID: " + id+".";
	}
	
	public String updateClassroom(Long id, String accountData) {
		Classroom updAccount = util.getObjectForJSON(accountData, Classroom.class);
		accountMap.replace(id, accountMap.get(id), updAccount);
		return "Updated Classroom at ID: "+id+".";
	}
	
	public String findClassroom(Long id) {
		return util.getJSONForObject(accountMap.get(id));
	}

}
