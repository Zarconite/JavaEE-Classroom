package com.qa.classroom.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.classroom.persistence.domain.Classroom;
import com.qa.classroom.persistence.domain.Trainee;
import com.qa.classroom.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDatabaseRepository implements ClassroomRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject private JSONUtil util;
	
	@Transactional(REQUIRED)
	public String createClassroom(String classroomData) {
		Classroom newClassroom = util.getObjectForJSON(classroomData, Classroom.class);
		em.persist(newClassroom);
		return "{\"message\": \"Classroom has been sucessfully added\"}";
	}
	
	public String getAllClassrooms() {
		//Query findAll = em.createQuery("select c.classroomID, c.trainer, t.traineeID, "
		//	+ "t.traineeName from Classroom c, Trainee t where c.classroomID = t.classroomID");
		Query findAll = em.createQuery("SELECT c FROM Classroom c");
		return util.getJSONForObject((Collection<Classroom>) findAll.getResultList());
	}
	
	public String findClassroom(Long id) {
		Classroom classroomInDB = em.find(Classroom.class, id);
		return util.getJSONForObject(classroomInDB);
	}
	
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroomData) {
		String currentClassroom = findClassroom(id);
		Classroom classroomObject = util.getObjectForJSON(classroomData, Classroom.class);
		if (currentClassroom != "null") {
			em.createQuery("update Classroom set trainer = '"+classroomObject.getTrainer()
			+"' where classroomID = "+id).executeUpdate();
			return "{\"message\": \"Classroom sucessfully updated\"}";
		}
		return "{\"message\": \"Classroom not found\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		String classroom = findClassroom(id);
		Classroom classroomToDelete = util.getObjectForJSON(classroom, Classroom.class);
		if (classroom != "null") {
			em.remove(em.contains(classroomToDelete) ? classroomToDelete : em.merge(classroomToDelete));
			return "{\"message\": \"Classroom sucessfully deleted\"}";
		}
		return "{\"message\": \"Classroom not found\"}";
	}
	
}
