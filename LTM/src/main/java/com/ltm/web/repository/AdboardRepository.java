package com.ltm.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ltm.web.entity.Adboard;

public interface AdboardRepository extends JpaRepository<Adboard, Integer>{
	
	Adboard findByAdtitle(String adtitle); // 제목으로 찾기
	Adboard findByAdtitleAndAdbody(String adtitle, String adbody); // 제목과 내용으로 찾기
	List<Adboard> findByAdtitleLike(String adtitle); // 특전 문자로 찾기
	Page<Adboard> findAll(Pageable pageable); // 페이징 구현
		
	@Modifying // 조회수 구현
	@Query("update Adboard q set q.view = q.view + 1 where q.id = :id")
	int updateView(@Param("id") Integer id);

}
