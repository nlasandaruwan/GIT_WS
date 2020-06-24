package spring4.core.componentscann.impl;

import spring4.core.componentscann.intf.CompactDisc;


public class ExternalPlayer implements CompactDisc{

	
	private String title = "ExternalPlayer's  Band";
	private String artist = "ExternalPlayer Artist";
	
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
