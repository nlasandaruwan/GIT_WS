package com.poc.RestWithJersey.services;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.poc.RestWithJersey.dao.DepartmentDao;
import com.poc.RestWithJersey.daoimpl.DepartmentDaoImpl;
import com.poc.RestWithJersey.domain.Department;

@Path("DepartmentService")
public class DepartmentService {

	private static DepartmentDao dao = new DepartmentDaoImpl();

	@POST
	@Path("addDepartment")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public Department addEmployeeForm(@BeanParam Department department ) {
		return dao.addDepartment(department);
	}
	
	// http://localhost:8080/RestWithJersey/webresources/DepartmentService/getDepartmentByName/name?Telin
	//http://localhost:8080/RestWithJersey/webresources/DepartmentService/getDepartmentByName?name=IT
		@GET
		@Path("getDepartmentByName")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Department getDepartmentByName(@Encoded @QueryParam("name") String name) {
			return dao.getDepartmentByName(name);
		}
		
		//http://localhost:8080/RestWithJersey/webresources/DepartmentService/getDepartmentById/11
		@GET
		@Path("getDepartmentById/{id}")
		@Produces("application/csv")
		public Department getDepartmentById(
				@PathParam("id") 
				@Min(value = 0, message = "Department Id must be a	positive value") 
				@Max(value = 11, message = "Department Id must be a	lessthan 11 value") int id) {
			return dao.getDepartmentById(id);
		}

}
