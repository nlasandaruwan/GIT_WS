package spring4.core.componentscann.implSeperate;



public class VehiclePlayer  {
	private String title = "VehiclePlayer's  Band";
	private String artist = "VehiclePlayer Artist";


	public VehiclePlayer() {
		System.out.println("Creating a VehiclePlayer........");
	}

	
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
