package spring4.core.componentscann.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring4.core.componentscann.impl.SgtPeppers;
import spring4.core.config.GenericConfig;

public class TestComponentsScann {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(GenericConfig.class);
		configApplicationContext.refresh();
		
		SgtPeppers peppers = (SgtPeppers) configApplicationContext.getBean("lonelyHeartsClub");
		peppers.play();
		
		peppers.getBlueRay().play();
		peppers.getCdPlayer().play();
		peppers.getVehiclePlayer().play();
		peppers.getMegaPlayer().play();
		peppers.getMiniPlayer().play();
		peppers.getExternalPlayer().play();
		peppers.getDvdPlayer().play();
		peppers.getThirdPartyPlayer().play();
		
	}
}
