package com.poc.RestWithJersey.filter.dynamic;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

public class RequestLoggerFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String URI = requestContext.getUriInfo().getRequestUri().toString();
		if (URI.contains("EmployeeService/getEmployeeById")) {

			if (requestContext.getMethod().equals("PUT")) {
				requestContext.setMethod("GET");
			}
		}
	}
}
