package com.ltm.web.entity.playlist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlSong {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pl_song_id")
	public Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pl_id")
	private PlayList playList;
	
	private String songTitle;
	private String singer;
	private String image;
	
	//==생성 메서드==//
	//플레이리스트,노래 데이터 삽입
	public static PlSong createPlSong(PlayList playList,String songTitle,String singer, String image) {
		PlSong plSong = new PlSong();
		plSong.setPlayList(playList);
		plSong.setSongTitle(songTitle);
		plSong.setSinger(singer);
		plSong.setImage(image);
		
		
		return plSong;
	}
}
