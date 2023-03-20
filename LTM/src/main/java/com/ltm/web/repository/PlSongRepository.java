package com.ltm.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ltm.web.entity.playlist.PlSong;

public interface PlSongRepository extends JpaRepository<PlSong,Long>{

	@Query(value = "select *"
			+ " from pl_song pls"
			+ " where pl_id = :plId" , nativeQuery =true)
	public List<PlSong> findSongList(@Param(value = "plId") Long plId);
	
	
}