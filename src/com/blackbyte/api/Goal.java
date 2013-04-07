package com.blackbyte.api;

import java.util.HashMap;

import org.json.JSONObject;

public class Goal extends Resource {
	public Goal(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Goal(Settings settings) {
		this.settings = settings;
	}
	
	public JSONObject getGoals(String projectId) {
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("project", projectId);
		return super.get("goal", null, params);
	}

}
