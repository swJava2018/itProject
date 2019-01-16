package com.sanan.demo.service.impl.kakao;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.sanan.demo.model.ModelObject;

public class SameName extends ModelObject {
	private ArrayList<String> region;
	private String keyword;
	private String selected_region;
	
	public ArrayList<String> getRegion() {
		return region;
	}

	public void setRegion(ArrayList<String> region) {
		this.region = region;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSelected_region() {
		return selected_region;
	}

	public void setSelected_region(String selected_region) {
		this.selected_region = selected_region;
	}

	@Override
    public void fromJSON(String json) {
    	Gson gson = new Gson();
    	SameName obj = gson.fromJson(json, SameName.class);
    	region = obj.getRegion();
    	keyword = obj.getKeyword();
    	selected_region = obj.getSelected_region();
    }
}
