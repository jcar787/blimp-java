package com.blackbyte.api;


public class Goal extends Resource {
	public Goal(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Goal(Settings settings) {
		this.settings = settings;
	}
	
}
