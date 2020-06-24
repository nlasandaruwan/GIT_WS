package spring4.core.externalValueInject.impl;

import org.springframework.beans.factory.annotation.Value;

import spring4.core.externalValueInject.intf.Disc;

public class BlankDisc implements Disc {

	private String title;
	private String artist;
	private int connection;
	
	@Value("${db.username}")
	private String userName;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${db.url}")
	private String dbURL;
	
	public BlankDisc(String title, String artist, int connect) {
		this.artist = artist;
		this.title = title;
		this.connection = connect;
	}

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		System.out.println("Number of Connections " + connection+ " User Name: " + userName+ " Password: " +password+ " DB URL " +dbURL);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}
