package spring4.core.autowire.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring4.core.autowire.manager.Manager;
import spring4.core.config.AutoWireConfig;

public class TestAutoWire {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(AutoWireConfig.class);
		configApplicationContext.refresh();
		
		Manager manager = (Manager) configApplicationContext.getBean("manager");
		
		manager.saveLogin();
	}
}
