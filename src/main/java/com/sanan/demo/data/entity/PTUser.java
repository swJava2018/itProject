package com.sanan.demo.data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ptuser")
public class PTUser {
	@Id
    private @Column(name = "id") String id;
    private @Column(name = "password") String password;
    
    @CreationTimestamp
    private @Column(name = "cdate") Timestamp cdate;
     
    @UpdateTimestamp
    private @Column(name = "udate") Timestamp udate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCdate() {
		return cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public Timestamp getUdate() {
		return udate;
	}

	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}
    
    
}
