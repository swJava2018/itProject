package com.sanan.demo.model;

import com.google.gson.Gson;

public class Enroll extends ModelObject {
	private String id;
    private String pwd;
    private String school;
    
    public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

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
    	Enroll obj = gson.fromJson(json, Enroll.class);
    	id = obj.getId();
    	pwd = obj.getPwd();
    }
}
