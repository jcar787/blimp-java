package com.blackbyte.api;


public class User extends Resource {
	public User(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public User(Settings settings) {
		this.settings = settings;
	}
}
