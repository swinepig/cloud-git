package com.habuma.spitter.entity;

import java.io.Serializable;

public class MusicInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1438648005255056034L;
	private String title;
	private String artist;
	private String mp3;
	private String poster;
	private String oga;

	public MusicInfo() {
		super();
	}

	public MusicInfo(String title, String artist, String mp3, String oga) {
		super();
		this.title = title;
		this.artist = artist;
		this.mp3 = mp3;
		this.oga = oga;
	}

	public MusicInfo(String title, String artist, String mp3, String poster,
			String oga) {
		super();
		this.title = title;
		this.artist = artist;
		this.mp3 = mp3;
		this.poster = poster;
		this.oga = oga;
	}

	
	public MusicInfo(String title, String mp3, String oga) {
		super();
		this.title = title;
		this.mp3 = mp3;
		this.oga = oga;
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

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getOga() {
		return oga;
	}

	public void setOga(String oga) {
		this.oga = oga;
	}

}
