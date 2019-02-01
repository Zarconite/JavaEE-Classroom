package com.qa.classroom.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.classroom.business.ClassroomService;

@Path("/Classroom")
//class i want to activate
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;

	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/findClassroom/{id}")
	@GET
	@Produces({ "application/json" })
	public String findClassroom(@PathParam("id") Long classroomID) {
		return service.findClassroom(classroomID);
	}

	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") Long classroomID, String classroomData) {
		return service.updateClassroom(classroomID, classroomData);
	}
	
	@Path("/createClassroom")
	@PUT
	@Produces({ "application/json" })
	public String addClassroom(String classroomData) {
		return service.addClassroom(classroomData);
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long classroomID) {
		return service.deleteClassroom(classroomID);
	}

	public void setService(ClassroomService service) {
		this.service = service;
	}

}
