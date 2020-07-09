package com.poc.RestWithJersey.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class EmployeeNotFoundUnChkedWebAppException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundUnChkedWebAppException() {
		super(Response.Status.NOT_FOUND);
	}

	public EmployeeNotFoundUnChkedWebAppException(String message) {
		super(Response.status(Status.NOT_FOUND).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
