package spring4.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({AutoWireConfig.class, CDPlayerConfig.class})
@ImportResource({"classpath*:XML_Beans.xml"})

public class GenericConfig {
	

}
