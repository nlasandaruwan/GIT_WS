package spring4.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring4.core.componentscann.impl.SgtPeppers;

@Configuration
@ComponentScan(basePackageClasses={spring4.core.componentscann.impl.SgtPeppers.class})
public class CDPlayerConfig {
	
	public SgtPeppers sgtPeppers(){
		return new SgtPeppers();
	}

}
