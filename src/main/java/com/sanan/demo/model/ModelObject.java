package com.sanan.demo.model;

import com.google.gson.Gson;

public abstract class ModelObject {
    public String toJSON() {
    	Gson gson = new Gson();
    	return gson.toJson(this);
    }
    
    public abstract void fromJSON(String json);
}
