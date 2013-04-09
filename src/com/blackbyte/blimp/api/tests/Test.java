package com.blackbyte.blimp.api.tests;

import java.util.ArrayList;

import org.json.JSONObject;

import com.blackbyte.blimp.api.Client;
import com.blackbyte.blimp.api.Settings;

public class Test {
	public static void main(String args[]) {
		Settings settings = new Settings();
		settings.setUsername("username");
		settings.setApiKey("apiKey");
		settings.setAppId("appId");
		settings.setAppSecret("appSecret");
		
		Client client = new Client(settings);
		JSONObject params = new JSONObject();
		try {
			params.put("name", "Testing The update again");
			//params.put("company", "/api/v2/company/3456/");
		ArrayList<String> array = new ArrayList<String>();
		array.add("/api/v2/user/4497/");
		params.put("team", array);
		String identifier = "4280";
		/*JSONObject json = client.getProject().deleteProject(identifier);
		//JSONObject json = client.getProject().getProjects("3456");
		

		
		if(json != null)
			System.out.println(json.toString());
		else
			System.out.println("=[");*/
		JSONObject json = client.getCompany().schema();
		System.out.println(json.toString());
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}
}
