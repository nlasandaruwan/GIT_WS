package spring4.core.componentscann.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import spring4.core.componentscann.intf.CompactDisc;

@Component
//@Primary
public class DVDPlayer {
	private String title = "DVDPlayer's  Band";
	private String artist = "DVDPlayer Artist";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
