package com.poc.RestWithJersey.services;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.poc.RestWithJersey.daoimpl.DepartmentDaoImpl;
import com.poc.RestWithJersey.domain.Department;

@Path("CachedService")
public class CachedService {

	// http://localhost:8080/RestWithJersey/webresources/CachedService/departments/1/holidays
	// http://localhost:8080/RestWithJersey/webresources/CachedService/departments/2/holidays
	@GET
	@Path("departments/{id}/holidays")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHolidayListForCurrentYear(@PathParam("id") Short deptId) {
		Department department = new DepartmentDaoImpl().getDepartmentById(deptId);
		department.getDepartmentCategory();
		// Reads the list of holidays
		List<String> holidayList = Arrays.asList("01/01/2020", "13/04/2020", "14/04/2020", "11/05/2021", "11/05/2022",
				"11/05/2023");
		// Build response
		Response.ResponseBuilder response = Response.ok(holidayList).type(MediaType.APPLICATION_JSON);
		// Set the expiry for response resource
		// This example sets validity as
		// Dec 31 of the current year
//		int currentYear = 2020;
//		Calendar expirationDate = new GregorianCalendar(currentYear, 12, 31);
//		response.expires(expirationDate.getTime());

		CacheControl cc = new CacheControl();
		cc.setMaxAge(60);
		cc.setPrivate(true);
		cc.setSMaxAge(60);
		response.cacheControl(cc);
		return response.build();
	}

	@GET
	@Path("departments/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findDepartmentWithCacheValidationWithLastModifiedDate(@PathParam("id") Short id,
			@Context Request request) {
		// Reads the latest Department object from DB
		Department department = new DepartmentDaoImpl().getDepartmentById(id);
		// Gets the last modified date
		Calendar calendar = Calendar.getInstance();
	
//		Date latModifiedDate = ;
		// Evaluates request preconditions on the basis
		// of the passed-in value.
		// evaluatePreconditions() return null If-Modified-Since
		// check succeeds. This implies that resource is modified
		ResponseBuilder builder = request.evaluatePreconditions(new Date());
		// cached resource did change; send new one
		if (builder == null) {
			builder = Response.ok(department);
			builder.lastModified(new Date());
		}
		return builder.build();
	}
}
