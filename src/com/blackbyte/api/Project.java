package com.blackbyte.api;


public class Project extends Resource {
	public Project(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Project(Settings settings) {
		super(settings);
	}
	
}
