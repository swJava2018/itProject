package com.sanan.demo.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class OpenAPIQuery extends ModelObject {
	private HashMap<String, Object> map;

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	@Override
	public void fromJSON(String json) {
		Gson gson = new Gson();
		OpenAPIQuery obj = gson.fromJson(json, OpenAPIQuery.class);
    	map = obj.getMap();
	}
	
	public String toUrlEncoded() throws UnsupportedEncodingException{
	    // application/x-www-form-urlencoded
		StringBuilder result = new StringBuilder();
	    boolean first = true;
	    for(Map.Entry<String, Object> entry : map.entrySet()){
	        if (first)
	            first = false;
	        else
	            result.append("&");    
	        result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
	        result.append("=");
	        
	        Object obj = entry.getValue();
	        if(obj instanceof Integer)
	        	result.append((Integer)obj);
	        else
	        	result.append(URLEncoder.encode((String)obj, "UTF-8"));
	    }    
	    return result.toString();
	}
}
