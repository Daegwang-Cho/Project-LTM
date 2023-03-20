package com.ltm.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ltm.web.entity.Cboard;

public interface CboardRepository extends JpaRepository<Cboard, Integer>{
	
	Cboard findByCtitle(String ctitle); // 제목으로 찾기
	Cboard findByCtitleAndCbody(String ctitle, String cbody); // 제목과 내용으로 찾기
	List<Cboard> findByCtitleLike(String ctitle); // 특전 문자로 찾기
	Page<Cboard> findAll(Pageable pageable); // 페이징 구현
	Page<Cboard> findAll(Specification<Cboard> spec, Pageable pageable); // 검색
		
	@Modifying // 조회수 구현
	@Query("update Cboard q set q.view = q.view + 1 where q.id = :id")
	int updateView(@Param("id") Integer id);

}
