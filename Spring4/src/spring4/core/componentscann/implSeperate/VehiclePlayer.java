package spring4.core.componentscann.implSeperate;

import spring4.core.componentscann.intf.CompactDisc;

public class VehiclePlayer{
	private String title = "VehiclePlayer's  Band";
	private String artist = "VehiclePlayer Artist";


	public VehiclePlayer() {
		System.out.println("Creating a VehiclePlayer........");
	}

	
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
