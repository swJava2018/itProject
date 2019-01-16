package com.sanan.demo.model;

import com.google.gson.Gson;

public class OpenAPIResult extends ModelObject {
	private String placeName;	
	private String link;
	private String linkMap;
	private String detail;
	private String detail_road;
	private String x;
	private String y;
	private String phone;
	
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLinkMap() {
		return linkMap;
	}

	public void setLinkMap(String linkMap) {
		this.linkMap = linkMap;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getDetail_road() {
		return detail_road;
	}

	public void setDetail_road(String detail_road) {
		this.detail_road = detail_road;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
    public void fromJSON(String json) {
    	Gson gson = new Gson();
    	OpenAPIResult obj = gson.fromJson(json, OpenAPIResult.class);
    	placeName = obj.getPlaceName();
    	link = obj.getLink();
    	linkMap = obj.getLinkMap();
    	detail = obj.getDetail();
    	detail_road = obj.getDetail_road();
    	x = obj.getX();
    	y = obj.getY();
    	phone = obj.getPhone();
    }
}
