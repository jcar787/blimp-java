package com.blackbyte.api;


public class Task extends Resource {
	public Task(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Task(Settings settings) {
		this.settings = settings;
	}

}
