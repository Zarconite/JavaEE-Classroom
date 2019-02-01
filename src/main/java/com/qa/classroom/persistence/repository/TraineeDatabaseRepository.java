package com.qa.classroom.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
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
public class TraineeDatabaseRepository implements TraineeRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject private JSONUtil util;
	
	@Transactional(REQUIRED)
	public String createTrainee(String traineeName) {
		Trainee newTrainee = util.getObjectForJSON(traineeName, Trainee.class);
		em.persist(newTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}
	
	public String getAllTrainees() {
		Query findAll = em.createQuery("SELECT a FROM Trainee a");
		return util.getJSONForObject((Collection<Trainee>) findAll.getResultList());
	}
	
	public String findTrainee(Long id) {
		Trainee trainee = em.find(Trainee.class, id);
		return util.getJSONForObject(trainee);
	}
	
	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeData) {
		String currentTrainee = findTrainee(id);
		Trainee trainee = util.getObjectForJSON(traineeData, Trainee.class);
		if (currentTrainee != "null") {
			em.createQuery("update Trainee set classroomID = "+trainee.getClassroomID()+", traineeName = '"+trainee.getTraineeName()
			+"' where traineeID = "+id).executeUpdate();
			return "{\"message\": \"Trainee sucessfully updated\"}";
		}
		return "{\"message\": \"Trainee not found\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		String trainee = findTrainee(id);
		Trainee traineeToDelete = util.getObjectForJSON(trainee, Trainee.class);
		if (trainee != "null") {
			em.remove(em.contains(traineeToDelete) ? traineeToDelete : em.merge(traineeToDelete));
			return "{\"message\": \"Trainee sucessfully deleted\"}";
		}
		return "{\"message\": \"Trainee not found\"}";
	}
	
}
