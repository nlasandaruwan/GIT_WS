package spring4.core.componentscann.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring4.core.componentscann.intf.CompactDisc;

@Component
public class ThirdPartyPlayer{

	@Autowired
	@Qualifier("blueRay")
	private CompactDisc compack;
	
	public ThirdPartyPlayer(CompactDisc compactDisc ) {
		System.out.println( "Calling ThirdPartyPlayer() ------------------" );
		this.compack = compactDisc;
		System.out.println(compactDisc);
	}
	
	
	public void play() {
		compack.play();
	}
}
