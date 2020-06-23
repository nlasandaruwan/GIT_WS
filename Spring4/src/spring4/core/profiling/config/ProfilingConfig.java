package spring4.core.profiling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring4.core.profiling.impl.DevelopmentDataSource;
import spring4.core.profiling.impl.ProductionDataSource;
import spring4.core.profiling.impl.QADataSource;

@Configuration
@ComponentScan({ "spring4.core.profiling.impl" })
public class ProfilingConfig {

	@Bean
	@Profile("DEV")
	public DevelopmentDataSource developmentDataSource() {

		return new DevelopmentDataSource();
	}

	@Bean
	@Profile("QA")
	public QADataSource qaDataSource() {
		return new QADataSource();
	}

	@Bean
	@Profile("PROD")
	public ProductionDataSource productionDataSource() {
		return new ProductionDataSource();
	}
}
