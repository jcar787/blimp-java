package com.blackbyte.api;

public class Settings {
	private String appId;
	private String appSecret;
	private String username;
	private String apiKey;
	
	public Settings(String username, String apiKey, String appId, String appSecret) {
		this.username = username;
		this.apiKey = apiKey;
		this.appId = appId;
		this.appSecret = appSecret;
	}
	
	public Settings() {
		appId = "";
		appSecret = "";
		username = "";
		apiKey = "";
	}
	
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public String getAppSecret() {
		return appSecret;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getApiKey() {
		return apiKey;
	}
}
