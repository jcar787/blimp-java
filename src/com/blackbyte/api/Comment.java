package com.blackbyte.api;

public class Comment extends Resource {

	public Comment(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Comment(Settings settings) {
		this.settings = settings;
	}
}
