package com.ltm.web.Dto;

import com.ltm.web.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayListFormDto {

	private String title;
	
	private String discription;
	
	private Member member;
}
