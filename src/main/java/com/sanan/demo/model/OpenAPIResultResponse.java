package com.sanan.demo.model;

import java.util.ArrayList;

import com.google.gson.Gson;


public class OpenAPIResultResponse extends ModelObject {
	private ArrayList<OpenAPIResult> list;
	private int pageableCnt;
	private int totalCnt;
	private String keyword;
	
	public ArrayList<OpenAPIResult> getList() {
		return list;
	}

	public void setList(ArrayList<OpenAPIResult> list) {
		this.list = list;
	}

	public int getPageableCnt() {
		return pageableCnt;
	}

	public void setPageableCnt(int pageableCnt) {
		this.pageableCnt = pageableCnt;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
    public void fromJSON(String json) {
    	Gson gson = new Gson();
    	OpenAPIResultResponse obj = gson.fromJson(json, OpenAPIResultResponse.class);
    	list = obj.getList();
    	pageableCnt = obj.getPageableCnt();
    	totalCnt = obj.getTotalCnt();
    	keyword = obj.getKeyword();
    }
}
