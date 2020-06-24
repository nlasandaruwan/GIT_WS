package spring4.core.externalValueInject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import spring4.core.externalValueInject.impl.BlankDisc;

@Configuration
@PropertySource("classpath:app.properties")
public class ExpressiveConfig {

	@Autowired
	Environment env;

	@Bean("blank")
	public BlankDisc disc() {
		return new BlankDisc(env.getProperty("disc.title"),
				env.getProperty("disc.artist"), env.getProperty("db.connection.count", Integer.class));
	}
	
	 @Bean
	    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
	        propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("web.properties"));
	        //propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
	        //propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
	        return propertySourcesPlaceholderConfigurer;
	    }
}
