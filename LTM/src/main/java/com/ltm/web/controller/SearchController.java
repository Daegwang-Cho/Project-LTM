package com.ltm.web.controller;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltm.web.api.SearchResultApi;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {

	private final SearchResultApi searchResultApi;
	
	@GetMapping("/search")
	public String searchSong() {
		return "playlist/Search";
	}
	
	@PostMapping("/search")
	public String searchResults(@RequestParam("songinfo") String songInfo, Model model) {
		
		JSONArray track = searchResultApi.songResults(songInfo);
		
		model.addAttribute("searchWord",songInfo);
		model.addAttribute("songList",track);
		return "playlist/SongResults";
	}
}
