package com.ltm.web.Dto;

import javax.validation.constraints.NotEmpty;

import com.ltm.web.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayListFormDto {

	@NotEmpty(message = "필수 입력란")
	private String title;
	
	private String discription;
	
	private Member member;
}
