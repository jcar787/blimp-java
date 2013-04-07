package com.blackbyte.api;

import java.util.HashMap;
import org.json.JSONObject;

public class Comment extends Resource {

	public Comment(String username, String apiKey, String appId, String appSecret) {
		super(username, apiKey, appId, appSecret);
	}
	
	public Comment(Settings settings) {
		this.settings = settings;
	}

	public JSONObject getComments(HashMap <String, String> params) {
		return super.get("comment", null, params);
	}

}
