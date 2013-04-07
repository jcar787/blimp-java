package com.blackbyte.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class Resource {
	protected static final String apiURL = "https://app.getblimp.com/api/v2/";
	protected Settings settings;

	public Resource() {
		
	}
	public Resource(String username, String apiKey, String appId, String appSecret) {
		settings = new Settings(username, apiKey, appId, appSecret);
	}
	
	private String createURL(String path, String identifier, HashMap<String, String> params) {
		StringBuilder url = new StringBuilder(apiURL + path);
		if(identifier != null)
			url.append("/"+identifier+"/");
		
		if(params != null) {
			 url.append("?");
			 String amp = "";
			for(Map.Entry<String, String> param : params.entrySet()) {
				url.append(amp);
				amp = "&";
				url.append(param.getKey());
				url.append("=");
				url.append(param.getValue());
			}
			
		}
		return url.toString();
	}

	protected JSONObject get(String path, String identifier, HashMap<String, String> params) {
		JSONObject response = new JSONObject();
		String url = createURL(path, identifier, params);
		response = getJSON(url, "GET");

		return response;
	}

	protected JSONObject post() {
		JSONObject response = new JSONObject();

		return response;
	}

	protected JSONObject put() {
		JSONObject response = new JSONObject();

		return response;
	}

	protected JSONObject delete() {
		JSONObject response = new JSONObject();

		return response;
	}
	
	private String readAll(BufferedReader rd) {
		try {
			StringBuilder result = new StringBuilder();
			String line = null;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			result.trimToSize();
			
			return result.toString();
		} catch (Exception ex) {
			return null;
		}
	}
	
	private String getStringFromURL(String url, String method) throws Exception {
		String result = "";
		try {
			HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
			
			conn.setRequestProperty("authorization", "ApiKey " + settings.getUsername()+":"+settings.getApiKey());
			conn.setRequestProperty("x_blimp_appid", settings.getAppId());
			conn.setRequestProperty("x_blimp_secret", settings.getAppSecret());
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestMethod(method);
			conn.setDoOutput(true);
			
			Map<String,List<String>> hf = conn.getRequestProperties();
			for (String key: hf.keySet ())
				System.out.println (key+": " + conn.getRequestProperty(key));
			
			conn.connect();
			
			InputStream is = conn.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			result = readAll(rd);
			
			return result;

		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	private JSONObject getJSON(String url, String method) {
		JSONObject json;
		try {
			String jsonText = getStringFromURL(url, method);
			json = new JSONObject(jsonText);
			return json;
		} catch (JSONException ex) {
			return null;
		} catch (Exception ex) {
			return null;
		}
	}


}
