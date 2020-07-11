package com.poc.RestWithJersey.filter.dynamic;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.poc.RestWithJersey.annotations.ResponseLogger;

@Provider
public class DynamicFeatureRegister implements DynamicFeature {

	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		if (resourceInfo.getResourceMethod().isAnnotationPresent(ResponseLogger.class)) {
			context.register(RequestLoggerFilter.class);
		}
	}
}
