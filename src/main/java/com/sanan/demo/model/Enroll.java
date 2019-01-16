package com.sanan.demo.model;

import com.google.gson.Gson;

public class Enroll extends ModelObject {
	private String id;
    private String password;
    
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

	@Override
    public void fromJSON(String json) {
    	Gson gson = new Gson();
    	Enroll obj = gson.fromJson(json, Enroll.class);
    	id = obj.getId();
    	password = obj.getPassword();
    }
}
