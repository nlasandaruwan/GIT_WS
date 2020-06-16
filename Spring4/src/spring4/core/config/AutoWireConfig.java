package spring4.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackageClasses={spring4.core.componentscann.impl.SgtPeppers.class})
@ComponentScan(basePackages={"spring4.core.autowire"})

public class AutoWireConfig {
	

}
