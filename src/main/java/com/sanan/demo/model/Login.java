package com.sanan.demo.model;

import com.google.gson.Gson;

public class Login extends ModelObject {
	private String id;
    private String pwd;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
    public void fromJSON(String json) {
    	Gson gson = new Gson();
    	Login obj = gson.fromJson(json, Login.class);
    	id = obj.getId();
    	pwd = obj.getPwd();
    }
}
