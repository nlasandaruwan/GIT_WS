package spring4.core.componentscann.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring4.core.componentscann.intf.CompactDisc;

public class MegaPlayer{

	@Autowired
	@Qualifier("externalPlayer")
	private CompactDisc compack;
	
	public MegaPlayer(CompactDisc compactDisc ) {
		System.out.println( "Calling MegaPlayer() ------------------" );
		this.compack = compactDisc;
		System.out.println(compactDisc);
	}
	
	
	public void play() {
		compack.play();
	}
}
