package spring4.core.componentscann.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring4.core.componentscann.implSeperate.VehiclePlayer;

@Component
@Named("lonelyHeartsClub")
public class SgtPeppers {
	
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	
	@Autowired
	private BlueRay blueRay;
	private CDPlayer cdPlayer;
	private VehiclePlayer vehiclePlayer;
	@Inject
	private DVDPlayer dvdPlayer;
	
	private ThirdPartyPlayer thirdPartyPlayer; 
	
	@Autowired
	private MiniPlayer miniPlayer;

	@Autowired
	private MegaPlayer megaPlayer;
	
	@Autowired
	private ExternalPlayer externalPlayer;
	
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
	
	public MiniPlayer getMiniPlayer() {
		return miniPlayer;
	}

	public ExternalPlayer getExternalPlayer() {
		return externalPlayer;
	}

	public DVDPlayer getDvdPlayer() {
		return dvdPlayer;
	}

	@Autowired
	public void setThirdPartyPlayer(ThirdPartyPlayer thirdPartyPlayer) {
		this.thirdPartyPlayer = thirdPartyPlayer;
	}

	public ThirdPartyPlayer getThirdPartyPlayer() {
		return thirdPartyPlayer;
	}
}
