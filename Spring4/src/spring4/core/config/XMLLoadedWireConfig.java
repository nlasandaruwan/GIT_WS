package spring4.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import spring4.core.componentscann.implSeperate.VehiclePlayer;

@Configuration
@ComponentScan(basePackages={"spring4.core.componentscann.implSeperate"})

public class XMLLoadedWireConfig {
	
	@Bean
//	@Primary
	public VehiclePlayer vehiclePlayer() {
		return new VehiclePlayer();
	}

}
