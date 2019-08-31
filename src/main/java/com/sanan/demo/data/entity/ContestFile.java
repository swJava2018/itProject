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
@Table(name = "contestFileT")
public class ContestFile {
	@Id
	private @Column(name = "id") int id;
	private @Column(name = "type") String type;
	private @Column(name = "url") String url;
	private @Column(name = "contest_id") int contest_id;
}
