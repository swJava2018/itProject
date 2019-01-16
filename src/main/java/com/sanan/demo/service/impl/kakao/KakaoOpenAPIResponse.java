package com.sanan.demo.service.impl.kakao;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.sanan.demo.model.ModelObject;

public class KakaoOpenAPIResponse extends ModelObject {
	private Meta meta;
	private SameName same_name;
	private ArrayList<Document> documents;
	
	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public SameName getSame_name() {
		return same_name;
	}

	public void setSame_name(SameName same_name) {
		this.same_name = same_name;
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}

	@Override
    public void fromJSON(String json) {
    	Gson gson = new Gson();
    	KakaoOpenAPIResponse obj = gson.fromJson(json, KakaoOpenAPIResponse.class);
    	meta = obj.getMeta();
    	same_name = obj.getSame_name();
    	documents = obj.getDocuments();
    }
}
