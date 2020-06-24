package spring4.core.qualifier.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring4.core.qualifier.config.QualifierConfig;
import spring4.core.qualifier.impl.DessertTaster;


public class TestQualifierScann {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(QualifierConfig.class);
		configApplicationContext.refresh();
		
		DessertTaster peppers = (DessertTaster) configApplicationContext.getBean("dessertTaster");
		peppers.getDessert().taste();

	}
}
