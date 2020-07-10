package com.poc.RestWithJersey.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		UriInfo info = requestContext.getUriInfo();
		String requestUri = info.getRequestUri().toString();

		int index = requestUri.indexOf("/config/");
		boolean isSettingsService = (index != -1);
		if (isSettingsService) {
			SecurityContext securityContext = requestContext.getSecurityContext();
			if (securityContext == null || !securityContext.isUserInRole("ADMIN")) {
				requestContext.abortWith(
						Response.status(Response.Status.UNAUTHORIZED).entity("Unauthorized access.").build());
			}
		}
	}
}
