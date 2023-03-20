package com.ltm.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ltm.web.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	
	Page<Reply> findAll(Pageable pageable); // 댓글 페이징 구현

}
