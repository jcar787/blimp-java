package com.blackbyte.api;

public class File extends Resource {
	public File(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public File(Settings settings) {
		this.settings = settings;
	}
}
