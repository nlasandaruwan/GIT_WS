package com.poc.RestWithJersey.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.poc.RestWithJersey.dao.EmployeeDao;
import com.poc.RestWithJersey.daoimpl.EmployeeDaoImpl;
import com.poc.RestWithJersey.domain.Employee;
import com.poc.RestWithJersey.exception.EmployeeNotFoundChkedWebAppException;

@Path("EmployeeService")
public class EmployeeService {

	private static EmployeeDao dao = new EmployeeDaoImpl();

	// http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployeeById/1
	@GET
	@Path("getEmployeeById/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployeeById(@PathParam("id") int id) {
		return dao.getEmployeeById(id);
	}

	// http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployeeByIdAndDept/1;city=Colombo;town=Piliyandala?dept=IT
	@GET
	@Path("getEmployeeByIdAndDept/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployeeByIdAndDept(@PathParam("id") int id, @QueryParam("dept") String dept,
			@MatrixParam("city") String city, @MatrixParam("town") String town, @HeaderParam("Referer") String referer,
			@CookieParam("Default-Dept") short departmentId) {
		return dao.getEmployeeByIdAndDept(id, dept);
	}

	// http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployeeByName/Telin
	@GET
	@Path("getEmployeeByName/{name:.*}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployeeByName(@PathParam("name") String name) {
		return dao.getEmployeeByName(name);
	}

	// http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployees
	@GET
	@Path("getEmployees")
	@Produces({ MediaType.APPLICATION_XML })
	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

	//http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployeesByName/T
	@GET
	@Path("getEmployeesByName/{name}")
	@Produces({ MediaType.APPLICATION_XML })
	public List<Employee> getEmployeesByName(@Context UriInfo uriInfo) {
		
		//http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployeesByName?name=T
		//return dao.getEmployeesByname(uriInfo.getQueryParameters().getFirst("name"));
		
		return dao.getEmployeesByname(uriInfo.getPathParameters().getFirst("name"));
	}

	// http://localhost:8080/RestWithJersey/webresources/EmployeeService/addEmployee
	@POST
	@Path("addEmployee")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee addEmployee(Employee employee) {
		return dao.addEmployees(employee);
	}

	// http://localhost:8080/RestWithJersey/webresources/EmployeeService/updateEmployee
	@PUT
	@Path("updateEmployee")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployees(employee);
	}

	//http://localhost:8080/RestWithJersey/webresources/EmployeeService/addEmployee
	@POST
	@Path("addEmployeeForm")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public Employee addEmployeeForm(@FormParam("departmentId") int departmentId,
			@FormParam("employeeName") String employeeName, @FormParam("departmentName") String departmentName,
			@FormParam("salary") int salary) {
		return dao.addEmployees(new Employee(departmentId, employeeName, departmentName, salary));
	}
	
	//http://localhost:8080/RestWithJersey/webresources/EmployeeService/deleteEmployee/17
		
	@DELETE
	@Path("deleteEmployee/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee deleteEmployee(@PathParam("id") int id) throws EmployeeNotFoundChkedWebAppException {
		
		Employee deleted = dao.deleteEmployees(id);
		
		if(deleted == null) {
//			throw new EmployeeNotFoundUnChkedWebAppException("Employee with Id : "+id +" has NOT been found !!! : ", Response.Status.NOT_FOUND);
//			throw new EmployeeNotFoundUnChkedWebAppException("Employee with Id : "+id +" has NOT been found !!! : ");
			throw new EmployeeNotFoundChkedWebAppException("Meaage EmployeeNotFoundChkedWebAppException");
		}
		return deleted;
	}

}
