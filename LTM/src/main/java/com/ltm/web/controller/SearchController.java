package com.ltm.web.controller;

import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltm.web.Service.MemberService;
import com.ltm.web.Service.PlayListService;
import com.ltm.web.api.SearchResultApi;
import com.ltm.web.entity.Member;
import com.ltm.web.entity.playlist.PlayList;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {

	private final SearchResultApi searchResultApi;
	private final MemberService memberService;
	private final PlayListService playListService;
	
	@GetMapping("/search")
	public String searchSong(Principal principal, Model model) {
		
		return "playlist/Search";
	}
	
	@PostMapping("/search")
	public String searchResults(@RequestParam("songinfo") String songInfo, Model model, Principal principal) {
		
		JSONArray track = searchResultApi.songResults(songInfo);
		
		Member member = this.memberService.getMember(principal.getName());

		// 내 플레이리스트 조회
		List<PlayList> myPlayList = playListService.findMemberPl(member.getIdNum());

		model.addAttribute("myList", myPlayList);
		
		model.addAttribute("searchWord",songInfo);
		model.addAttribute("songList",track);
		return "playlist/SongResults";
	}
}
