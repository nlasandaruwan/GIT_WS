package spring4.core.profiling.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring4.core.profiling.config.GenericConfig;


public class TestProfilingScann {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(GenericConfig.class);
		configApplicationContext.refresh();

	}
}
