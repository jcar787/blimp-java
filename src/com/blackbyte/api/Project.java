package com.blackbyte.api;

import java.util.HashMap;

import org.json.JSONObject;

public class Project extends Resource {
	public Project(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Project(Settings settings) {
		this.settings = settings;
	}
	
	public JSONObject getProjects(String companyId) {
		HashMap<String,String> params = new HashMap<String, String>();
		params.put("company", companyId);
		return super.get("project", null, params);
	}
}
