package com.qa.classroom.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.classroom.business.TraineeService;

@Path("/Trainee")
//class i want to activate
public class TraineeEndpoint {
	
	@Inject
	private TraineeService service;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@Path("/findTrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String findTrainee(@PathParam("id") Long traineeID) {
		return service.findTrainee(traineeID);
	}

	@Path("/updateTrainee/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long traineeID, String traineeName) {
		return service.updateTrainee(traineeID, traineeName);
	}
	
	@Path("/createTrainee")
	@PUT
	@Produces({ "application/json" })
	public String addTrainee(String traineeName) {
		return service.addTrainee(traineeName);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long traineeID) {
		return service.deleteTrainee(traineeID);
	}

	public void setService(TraineeService service) {
		this.service = service;
	}

}
