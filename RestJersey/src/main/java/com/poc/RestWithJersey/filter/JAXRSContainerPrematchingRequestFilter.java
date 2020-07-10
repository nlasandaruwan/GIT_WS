package com.poc.RestWithJersey.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class JAXRSContainerPrematchingRequestFilter implements ContainerRequestFilter {

	//http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployeesByName/T
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String URI = requestContext.getUriInfo().getRequestUri().toString();
		if (URI.contains("EmployeeService/getEmployeesByName/")) {

			if (requestContext.getMethod().equals("PUT")) {
				requestContext.setMethod("GET");
			}
		}
	}
}
