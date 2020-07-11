package com.poc.RestWithJersey.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

	// http://localhost:8080/RestWithJersey/webresources/EmployeeService/getEmployeesByName/T
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext cres) throws IOException {
		// Specify CORS headers: * represents allow all values
		String URI = requestContext.getUriInfo().getRequestUri().toString();
		if (URI.contains("EmployeeService/getEmployeesByName")) {

			cres.getHeaders().add("Access-Control-Allow-Origin", "*");
			cres.getHeaders().add("Access-Control-Allow-Headers", "*");
			cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
			cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
			cres.getHeaders().add("Access-Control-Max-Age", "1209600");
		}
	}

}
