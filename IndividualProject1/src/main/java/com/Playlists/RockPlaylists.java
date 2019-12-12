package com.Playlists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;

@Entity
public class RockPlaylists {

	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String url;
	private String playlistName;
	private String subGenre;
	private String featuredArtist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getplaylistName() {
		return playlistName;
	}
	public void setplaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public String getsubGenre() {
		return subGenre;
	}
	public void setsubGenre(String subGenre) {
		this.subGenre = subGenre;
	}
	public String getfeaturedArtist() {
		return featuredArtist;
	}
	public void setfeaturedArtist(String featuredArtist) {
		this.featuredArtist = featuredArtist;
	}
	
	
}
