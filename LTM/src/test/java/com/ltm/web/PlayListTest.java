package com.ltm.web;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ltm.web.entity.Member;
import com.ltm.web.entity.playlist.PlayList;
import com.ltm.web.repository.MemberRepository;
import com.ltm.web.repository.PlayListRepository;

@SpringBootTest
@Transactional
public class PlayListTest {

	@Autowired MemberRepository memberRepository;
	@Autowired PlayListRepository playListRepository;
	
	@Test
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
