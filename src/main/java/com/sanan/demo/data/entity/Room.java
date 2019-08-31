package com.sanan.demo.data.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roomT")
public class Room {
	@Id
	private @Column(name = "id") int id;
	private @Column(name = "roomPT_StartTime") Timestamp roomPT_StartTime;
	private @Column(name = "roomPT_UpdateTime") Timestamp roomPT_UpdateTime;
	private @Column(name = "roomPT_Name") String roomPT_Name;
	private @Column(name = "roomPT_IdIntroduce") String roomPT_IdIntroduce;
	private @Column(name = "roomPT_PersonneedExplain") String roomPT_PersonneedExplain;
	private @Column(name = "roomPT_PersonneedNum") int roomPT_PersonneedNum;
	private @Column(name = "roomPT_CooperationState") String roomPT_CooperationState;
	private @Column(name = "roomPT_LikeNum") int roomPT_LikeNum;
	private @Column(name = "contest_id") int contest_id;
	private @Column(name = "user_id") int user_id;
}
