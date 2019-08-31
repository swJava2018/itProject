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
@Table(name = "contestT")
public class Contest {
	@Id
	private @Column(name = "id") int id;
	private @Column(name = "name") String name;
	private @Column(name = "intro") String intro;
	private @Column(name = "organization") String organization;
	private @Column(name = "receiptStart") Timestamp receiptStart;
	private @Column(name = "receiptEnd") Timestamp receiptEnd;
	private @Column(name = "openStart") Timestamp openStart;
	private @Column(name = "openEnd") Timestamp openEnd;
	private @Column(name = "imageURL") String imageURL;
	private @Column(name = "homepageURL") String homepageURL;
	private @Column(name = "attachedFileURL") String attachedFileURL;
}
