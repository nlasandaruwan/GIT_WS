package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		String prefix = "/config";
		String[] paths = { 
				prefix + "/JMS-beans-main.xml" };	
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(paths);
	}
}
