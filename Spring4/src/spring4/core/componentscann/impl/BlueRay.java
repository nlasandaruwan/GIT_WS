package spring4.core.componentscann.impl;

import org.springframework.stereotype.Component;

import spring4.core.componentscann.intf.CompactDisc;

@Component
public class BlueRay  implements CompactDisc	{
	private String title = "BlueRay's  Band";
	private String artist = "BlueRay Artist";

	public BlueRay() {
		System.out.println("Creating a BlueRay........");
	}

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
