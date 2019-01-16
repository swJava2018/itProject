package com.sanan.demo.service.impl.kakao;

import com.google.gson.Gson;
import com.sanan.demo.model.ModelObject;

public class Meta extends ModelObject {
	private int total_count;
	private int pageable_count;
	private boolean is_end;
	private SameName same_name;
	
	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getPageable_count() {
		return pageable_count;
	}

	public void setPageable_count(int pageable_count) {
		this.pageable_count = pageable_count;
	}

	public boolean isIs_end() {
		return is_end;
	}

	public void setIs_end(boolean is_end) {
		this.is_end = is_end;
	}

	public SameName getSame_name() {
		return same_name;
	}

	public void setSame_name(SameName same_name) {
		this.same_name = same_name;
	}

	@Override
    public void fromJSON(String json) {
    	Gson gson = new Gson();
    	Meta obj = gson.fromJson(json, Meta.class);
    	total_count = obj.getTotal_count();
    	pageable_count = obj.getPageable_count();
    	is_end = obj.isIs_end();
    	same_name = obj.getSame_name();
    }
}
