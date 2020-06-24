package spring4.core.externalValueInject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring4.core.externalValueInject.config.ExpressiveConfig;
import spring4.core.externalValueInject.impl.BlankDisc;
import spring4.core.externalValueInject.intf.Disc;


public class TestExternalinjectValues {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(ExpressiveConfig.class);
		configApplicationContext.refresh();
		
		Disc peppers = (BlankDisc) configApplicationContext.getBean("blank");
		peppers.play();

	}
}
