package com.sanan.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContestReg {
	
	//공모전 이름/설명
	private String name;
	private String intro;
	
	//공모전 분야/부문
	private String field;
	private String department;
	
	//공모전 주최명/지역명
	private String organizationName;
	private String organizationArea;
	
	//공모전 접수기간
	private String subStart;
	private String subEnd;
	
	//공모전 예선기간
	private String preStart;
	private String preEnd;
	
	//공모전 본선기간
	private String onStart;
	private String onEnd;
	
	//공모전 URL
	private String homepageURL;
	
	//공모전 이미지 (URL)
	private String imageURL;
	
	//공모전 추가자료 (URL)
	private String attachedFileURL;
}
