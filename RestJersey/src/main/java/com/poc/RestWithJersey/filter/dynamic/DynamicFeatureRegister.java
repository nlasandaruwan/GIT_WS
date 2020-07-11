package com.poc.RestWithJersey.filter.dynamic;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.poc.RestWithJersey.annotations.DynamicDataCheck;
import com.poc.RestWithJersey.annotations.DynamicResponseLogger;

@Provider
public class DynamicFeatureRegister implements DynamicFeature {

	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		if (resourceInfo.getResourceMethod().isAnnotationPresent(DynamicResponseLogger.class)) {
			context.register(DynamicRequestLoggerFilter.class);
		}
		if (resourceInfo.getResourceMethod().isAnnotationPresent(DynamicDataCheck.class)) {
			context.register(DynamicDataCheckFilter.class);
		}
	}
}
