package spring4.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring4.core.componentscann.impl.MegaPlayer;
import spring4.core.componentscann.impl.VehiclePlayer;
import spring4.core.componentscann.intf.CompactDisc;

@Configuration
// @ComponentScan(basePackageClasses={spring4.core.componentscann.impl.SgtPeppers.class})
@ComponentScan(basePackages = { "spring4.core" })
public class CDPlayerConfig {

	@Bean
	public VehiclePlayer vehiclePlayer() {
		return new VehiclePlayer();
	}

	/*@Bean()
	public MegaPlayer megaPlayer() {
		return new MegaPlayer(vehiclePlayer());
	}*/

	@Bean
	public MegaPlayer megaPlayer(CompactDisc compactDisc) {
		return new MegaPlayer(compactDisc);
	}
}
