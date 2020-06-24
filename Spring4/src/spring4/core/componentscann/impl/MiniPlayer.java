package spring4.core.componentscann.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring4.core.componentscann.intf.CompactDisc;

public class MiniPlayer{

	@Autowired
	@Qualifier("blueRay")
	private CompactDisc compack;
	
	public MiniPlayer(CompactDisc compactDisc ) {
		System.out.println( "Calling MiniPlayer() ------------------" );
		this.compack = compactDisc;
		System.out.println(compactDisc);
	}
	
	
	public void play() {
		compack.play();
	}
}
