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
@Table(name = "favoritRoomT")
public class FavoritRoom {
	@Id
	private @Column(name = "id") int id;
	private @Column(name = "room_id") int room_id;
	private @Column(name = "user_id") int user_id;
}
