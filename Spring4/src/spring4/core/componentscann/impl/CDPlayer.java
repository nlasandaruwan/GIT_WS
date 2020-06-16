package spring4.core.componentscann.impl;

import org.springframework.stereotype.Component;

import spring4.core.componentscann.intf.CompactDisc;

@Component
public class CDPlayer{
	private String title = "CDPlayer's  Band";
	private String artist = "CDPlayer Artist";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
