package com.blackbyte.api.tests;

import org.json.JSONObject;

import com.blackbyte.api.Client;
import com.blackbyte.api.Settings;

public class Test {
	public static void main(String args[]) {
		Settings settings = new Settings();
		settings.setUsername("username");
		settings.setApiKey("apiKey");
		settings.setAppId("appId");
		settings.setAppSecret("appSecret");
		
		Client client = new Client(settings);
		JSONObject json = client.getCompany().getCompanies();
		
		if(json != null)
			System.out.println(json.toString());
		else
			System.out.println("=[");
	}
}
