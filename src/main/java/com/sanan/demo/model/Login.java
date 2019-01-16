package com.sanan.demo.model;

import com.google.gson.Gson;

public class Login extends ModelObject {
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
    	Login obj = gson.fromJson(json, Login.class);
    	id = obj.getId();
    	password = obj.getPassword();
    }
}
