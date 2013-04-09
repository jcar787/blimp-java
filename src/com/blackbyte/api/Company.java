package com.blackbyte.api;


public class Company extends Resource {

	public Company(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Company(Settings settings) {
		super(settings);
	}
}
