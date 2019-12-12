package com.Playlists;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Playlists.RockPlaylists;
import com.Playlists.RockPlaylistsRepo;

@RestController
public class DBFController {
	
	@Autowired
	private RockPlaylistsRepo repo;
		
	@GetMapping("/showAllLists")
	public ArrayList<RockPlaylists> findAll() {
			return repo.findAll();
}
	@GetMapping("/findByUrl/{u}")
	public RockPlaylists showUrl(@PathVariable String u) {
		return repo.findByurl(u);
	}
	@GetMapping("/findByPlayListName/{pn}")
	public ArrayList<RockPlaylists> findByPlaylistName (@PathVariable String pn) {
		return repo.findByplaylistName(pn);
	}
	@GetMapping("/findBySubGenre/{sg}")
	public ArrayList<RockPlaylists> findBySubGenre(@PathVariable String sg) {
		return repo.findBysubGenre(sg);	
	}
	@GetMapping("/findByFeaturedArtist/{a}")
	public ArrayList<RockPlaylists> findByFeaturedArtist(@PathVariable String a) {
		return repo.findByfeaturedArtist(a);
	}
	@GetMapping("/findBySubGenreandFeaturedArtist/{s}/{ar}")
	public ArrayList<RockPlaylists> findBysubGenreAndFeaturedArtist(@PathVariable String s, @PathVariable String ar) {
		return repo.findBysubGenreAndFeaturedArtist(s, ar);
	}
	@PostMapping("/Save/{url}/{playlistName}/{subgenre}/{featuredArtist}")
	public void SaveData (@PathVariable int id, @PathVariable String url, @PathVariable String playlistName, @PathVariable String subGenre, @PathVariable String featuredArtist) {
		RockPlaylists Ref = new RockPlaylists();
		Ref.setId(id);
		Ref.setUrl(url);
		Ref.setplaylistName(playlistName);
		Ref.setsubGenre(subGenre);
		Ref.setfeaturedArtist(featuredArtist);
		repo.save(Ref);
	}
	@RequestMapping("/save")
	public String SaveData (@RequestBody RockPlaylists Ref) {
		if (Ref.getfeaturedArtist()=="Nickelback") {
			return "Save unsuccessful";
		} else {
			repo.save(Ref);
			return "Record saved";
		}
	}
	@DeleteMapping("/Deleteby/{playlistName}")
	public void DeletebyPlaylistName (@PathVariable String playlistName) {
		RockPlaylists Ref = new RockPlaylists();
		Ref.getplaylistName();
		repo.delete(Ref);
		
		
	}
}
