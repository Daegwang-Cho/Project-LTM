package com.ltm.web;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ltm.web.Service.PlayListService;
import com.ltm.web.entity.Member;
import com.ltm.web.entity.playlist.PlayList;
import com.ltm.web.repository.MemberRepository;
import com.ltm.web.repository.PlayListRepository;

@SpringBootTest
public class PlayListTest {

	@Autowired MemberRepository memberRepository;
	@Autowired PlayListRepository playListRepository;
	@Autowired PlayListService playListService;
	
//	@Test
//	@Transactional
	public void 플레이리스트_생성(){
		//given
		Member member = createMember();
		PlayList playList = createPl(member);
		
		//when
		PlayList getPlayList = playListRepository.findById(playList.getId())
				.orElseThrow(EntityNotFoundException::new);
		
		//then
		assertEquals(playList.getId(), getPlayList.getId());
		
	}
	
//	@Test
//	@Transactional
	public void 플레이리스트_업데이트() throws Exception {
		//given
		Member member = createMember();
		PlayList playList = createPl(member);
		
		//when
		PlayList updatePl = playListService.updatePl(playList.getId(), "바뀐제목", "바뀐설명");
		
		//then
		assertEquals(updatePl.getId(), playList.getId());
		assertEquals("바뀐제목", updatePl.getTitle());
		assertEquals("바뀐설명", updatePl.getDiscription());
	}
	
	@Test
	@Transactional
	public void 플레이리스트_삭제() throws Exception {
		//given
		Member member = createMember();
		PlayList playList = createPl(member);
		
		//when
		PlayList getPl = playListService.getPl(playList.getId());
		playListService.deletePlayList(getPl);
		
		//then
		assertEquals(null, getPl);
	}
	
	private Member createMember() {
		Member member = new Member();
		member.setUsername("test1");
		member.setPassword("000000000");
		member.setEmail("test@test.com");
		member.setBirth("2001-01-12");
		member.setJoindate(LocalDateTime.now());
		
		memberRepository.save(member);
		return member;
	}
	
	private PlayList createPl(Member member) {
		PlayList playList = new PlayList();
		playList.setTitle("퇴근");
		playList.setDiscription("퇴근 노래");
		playList.setMember(member);
		
		playListRepository.save(playList);
		return playList;
	}
}
