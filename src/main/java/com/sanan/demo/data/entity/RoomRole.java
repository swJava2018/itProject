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
@Table(name = "roomRoleT")
public class RoomRole {
	@Id
	private @Column(name = "id") int id;
	private @Column(name = "role") String role;
	private @Column(name = "skill") String skill;
	private @Column(name = "room_id") int room_id;
}
