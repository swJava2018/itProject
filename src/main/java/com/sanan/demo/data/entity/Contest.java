package com.sanan.demo.data.entity;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contestT")
public class Contest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private @Column(name = "id") int id;
	
	//공모전 이름/설명
	private @Column(name = "name") String name;
	private @Column(name = "intro") String intro;
	
	//공모전 분야/부문
	private @Column(name = "field") String field;
	private @Column(name = "department") String department;
	
	//공모전 주최명/지역명
	private @Column(name = "organizationName") String organizationName;
	private @Column(name = "organizationArea") String organizationArea;
	
	//공모전 접수기간
	private @Column(name = "subStart") LocalDate subStart;
	private @Column(name = "subEnd") LocalDate subEnd;
	
	//공모전 예선기간
	private @Column(name = "preStart") LocalDate preStart;
	private @Column(name = "preEnd") LocalDate preEnd;
	
	//공모전 본선기간
	private @Column(name = "onStart") LocalDate onStart;
	private @Column(name = "onEnd") LocalDate onEnd;
	
	//공모전 좋아요
	private @Column(name = "likeNum") int likeNum;
	
	//공모전 URL
	private @Column(name = "homepageURL") String homepageURL;
	
	//공모전 이미지 (URL)
	private @Column(name = "imageURL") String imageURL;
	
	//공모전 추가자료 (URL)
	private @Column(name = "attachedFileURL") String attachedFileURL;
}
