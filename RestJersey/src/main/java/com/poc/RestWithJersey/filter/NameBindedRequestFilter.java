package com.poc.RestWithJersey.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import com.poc.RestWithJersey.annotations.RequestLogger;

@RequestLogger
@Provider
public class NameBindedRequestFilter implements ContainerRequestFilter {
//http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployees
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		UriInfo info = requestContext.getUriInfo();
		String requestUri = info.getRequestUri().toString();

		int index = requestUri.indexOf("/EmployeeService/getEmployees");
		boolean isSettingsService = (index != -1);
		if (isSettingsService) {
			System.out.println("Calling NameBindedRequestFilter !! ......................");
			if (requestContext.getMethod().equals("PUT")) {
				requestContext.setMethod("GET");
			}
		}
	}
}
