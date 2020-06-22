package spring4.core.componentscann.impl;

import org.springframework.beans.factory.annotation.Autowired;

import spring4.core.componentscann.intf.CompactDisc;

public class MiniPlayer{

	
	private CompactDisc compack;
	
//	@Autowired
	public MiniPlayer(CompactDisc compactDisc ) {
		System.out.println( "Calling MiniPlayer() ------------------" );
		this.compack = compactDisc;
		System.out.println(compactDisc);
	}
	
	
	public void play() {
		compack.play();
	}
}
