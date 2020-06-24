package spring4.core.qualifier.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({ QualifierConfig.class })
public class GenericConfig {

}
