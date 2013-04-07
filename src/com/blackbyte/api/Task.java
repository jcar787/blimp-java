package com.blackbyte.api;

import java.util.HashMap;

import org.json.JSONObject;

public class Task extends Resource {
	public Task(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Task(Settings settings) {
		this.settings = settings;
	}
	
	public JSONObject getTasks(String goalId) {
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("goal", goalId);
		return super.get("task", null, params);
	}

}
