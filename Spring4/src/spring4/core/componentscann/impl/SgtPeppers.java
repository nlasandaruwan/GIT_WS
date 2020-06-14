package spring4.core.componentscann.impl;

import org.springframework.stereotype.Component;

import spring4.core.componentscann.intf.CompactDisc;

@Component()
public class SgtPeppers implements CompactDisc {
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
