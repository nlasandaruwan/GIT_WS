package spring4.core.componentscann.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring4.core.componentscann.impl.SgtPeppers;
import spring4.core.config.CDPlayerConfig;

public class TestComponentsScann {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(CDPlayerConfig.class);
		configApplicationContext.refresh();
		
		SgtPeppers peppers = (SgtPeppers) configApplicationContext.getBean("sgtPeppers");
		peppers.play();
	}
}
