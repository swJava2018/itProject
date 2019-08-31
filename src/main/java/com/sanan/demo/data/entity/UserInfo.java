package com.sanan.demo.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "userInfoT")
public class UserInfo {
	@Id
	private @Column(name = "id") int id;
	private @Column(name = "userInfoT_Nickname") String userInfoT_Nickname;
	private @Column(name = "userInfoT_Sex") String userInfoT_Sex;
	private @Column(name = "userInfoT_Birthday") String userInfoT_Birthday;
	private @Column(name = "userInfoT_Email") String userInfoT_Email;
	private @Column(name = "userInfoT_Phone") String userInfoT_Phone;
	private @Column(name = "userInfoT_ImageURL") String userInfoT_ImageURL;
	private @Column(name = "facebook_id") String facebook_id;
	private @Column(name = "google_id") String google_id;
	private @Column(name = "naver_id") String naver_id;
}
