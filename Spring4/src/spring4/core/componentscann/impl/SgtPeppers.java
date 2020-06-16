package spring4.core.componentscann.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring4.core.componentscann.intf.CompactDisc;

@Component
@Named("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
	
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	
	@Autowired
	private BlueRay blueRay;
	private CDPlayer cdPlayer;
	private VehiclePlayer vehiclePlayer;
	
	@Autowired
	private MegaPlayer megaPlayer;
	
	public SgtPeppers(){}
	
	@Inject
	public SgtPeppers(CDPlayer cdPlayer){
		 this.cdPlayer = cdPlayer;
	}

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

	public BlueRay getBlueRay() {
		return blueRay;
	}

	public CDPlayer getCdPlayer() {
		return cdPlayer;
	}

	public VehiclePlayer getVehiclePlayer() {
		return vehiclePlayer;
	}

	@Autowired
	public void setVehiclePlayer(VehiclePlayer vehiclePlayer) {
		this.vehiclePlayer = vehiclePlayer;
	}

	public MegaPlayer getMegaPlayer() {
		return megaPlayer;
	}
}
