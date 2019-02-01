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
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	public String getAllTrainees() {
		Query findAll = em.createQuery("SELECT a FROM Account a");
		return util.getJSONForObject((Collection<Trainee>) findAll.getResultList());
	}
	
	public String findTrainee(Long id) {
		Trainee trainee = em.find(Trainee.class, id);
		return util.getJSONForObject(trainee);
	}
	
	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeName) {
		String currentAccount = findTrainee(id);
		if (currentAccount != "null") {
			deleteTrainee(id);
			createTrainee(traineeName);
			return "{\"message\": \"account sucessfully updated\"}";
		}
		return "{\"message\": \"account not found\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		String trainee = findTrainee(id);
		if (trainee != "null") {
			em.remove(trainee);
			return "{\"message\": \"account sucessfully deleted\"}";
		}
		return "{\"message\": \"account not found\"}";
	}
	
}
