package com.poc.RestWithJersey.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.poc.RestWithJersey.exception.EmployeeNotFoundChkedWebAppException;

@Provider
public class EmployeeNotFoundExceptionMapper implements ExceptionMapper<EmployeeNotFoundChkedWebAppException> {

	@Override
	public Response toResponse(EmployeeNotFoundChkedWebAppException exception) {
		return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
	}
}
