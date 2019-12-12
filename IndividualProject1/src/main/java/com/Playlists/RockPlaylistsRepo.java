package com.Playlists;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RockPlaylistsRepo extends JpaRepository<RockPlaylists, Integer> {
	public ArrayList<RockPlaylists> findAll();
	public RockPlaylists findByurl(String u);
	public ArrayList<RockPlaylists> findByplaylistName(String pn);
	public ArrayList<RockPlaylists> findBysubGenre(String sg);
	public ArrayList<RockPlaylists> findByfeaturedArtist(String a);
	public ArrayList<RockPlaylists> findBysubGenreAndFeaturedArtist(String s, String ar);
}
