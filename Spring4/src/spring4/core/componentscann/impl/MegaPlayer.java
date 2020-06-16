package spring4.core.componentscann.impl;

import spring4.core.componentscann.intf.CompactDisc;

public class MegaPlayer{

	
	private CompactDisc compack;
	
	public MegaPlayer(CompactDisc compactDisc ) {
		this.compack = compactDisc;
	}
	
	
	public void play() {
		compack.play();
	}
}
