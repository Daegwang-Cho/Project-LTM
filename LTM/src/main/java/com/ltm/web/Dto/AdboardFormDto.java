package com.ltm.web.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdboardFormDto {
	
	@NotEmpty(message="제목을 입력해주세요")
	@Size(max=50)
	private String adtitle;
	
	@NotEmpty(message="내용을 입력해주세요")
	private String adbody;

	private String tags;
}
