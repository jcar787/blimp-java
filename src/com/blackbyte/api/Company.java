package com.blackbyte.api;

import org.json.JSONObject;

public class Company extends Resource {

	public Company(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Company(Settings settings) {
		this.settings = settings;
	}
	
	public JSONObject getCompanies() {
		return super.get("company", null, null);
	}
	
	public JSONObject getCompany(String id) {
		return super.get("company", id, null);
	}
	
}
