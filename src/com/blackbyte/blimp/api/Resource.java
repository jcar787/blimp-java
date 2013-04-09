package com.blackbyte.blimp.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
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
	protected String path;

	public Resource() {

	}

	public Resource(String username, String apiKey, String appId, String appSecret) {
		settings = new Settings(username, apiKey, appId, appSecret);
		path = getClassName().toLowerCase();
	}
	
	public Resource(Settings settings) {
		this.settings = settings;
		path = getClassName().toLowerCase();
	}

	private String createURL(String path, String identifier, HashMap<String, String> params) {
		StringBuilder url = new StringBuilder(apiURL + path+ "/");
		if (identifier != null)
			url.append(identifier + "/");

		if (params != null) {
			url.append("?");
			String amp = "";
			for (Map.Entry<String, String> param : params.entrySet()) {
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
		response = getJSON(url, "GET", null);

		return response;
	}

	protected JSONObject post(String path, JSONObject params) {
		JSONObject response = new JSONObject();
		String url = createURL(path, null, null);
		response = getJSON(url, "POST", params);
		
		return response;
	}

	protected JSONObject put(String path, String identifier, JSONObject params) {
		JSONObject response = new JSONObject();
		String url = createURL(path, identifier, null);
		response = getJSON(url, "PUT", params);
		return response;
	}

	protected JSONObject patch() {
		JSONObject response = new JSONObject();

		return response;
	}

	protected JSONObject delete(String path, String identifier) {
		JSONObject response = new JSONObject();
		String url = createURL(path, identifier, null);
		response = getJSON(url, "DELETE", null);

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

	private String getStringFromURL(String url, String method, JSONObject params)
			throws Exception {
		String result = "";
		try {
			HttpsURLConnection conn = (HttpsURLConnection) (new URL(url)
					.openConnection());

			conn.setRequestMethod(method);
			conn.setRequestProperty("authorization", "ApiKey " + settings.getUsername() + ":"+ settings.getApiKey());
			conn.setRequestProperty("x_blimp_appid", settings.getAppId());
			conn.setRequestProperty("x_blimp_secret", settings.getAppSecret());
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("content-type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			if(params != null)
				conn.setFixedLengthStreamingMode(params.toString().getBytes().length);

			Map<String, List<String>> hf = conn.getRequestProperties();
			for (String key : hf.keySet())
				System.out.println(key + ": " + conn.getRequestProperty(key));
			
			
			
			if (method.equals("POST") || method.equals("PUT")) 
				writeOutput(conn, params);
			
			System.out.println(conn.getResponseCode());
			InputStream is;
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK || 
					conn.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED ||
					conn.getResponseCode() == HttpURLConnection.HTTP_CREATED || 
					conn.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT)
				is = conn.getInputStream();
			else
				is = conn.getErrorStream();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					is, Charset.forName("UTF-8")));
			result = readAll(rd);
			
			conn.disconnect();
			
			return result;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private JSONObject getJSON(String url, String method, JSONObject params) {
		JSONObject json;
		try {
			String jsonText = getStringFromURL(url, method, params);
			json = new JSONObject(jsonText);
			return json;
		} catch (JSONException ex) {
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	private void writeOutput(HttpsURLConnection conn, JSONObject params) {
		try {
			OutputStream os = conn.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			writer.write(params.toString());
			writer.flush();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + " In getStringFromURL");
		}
	}
	
	public String getClassName() {
		return getClass().getSimpleName();
	}
	
	public JSONObject getObj(String identifier, HashMap<String, String>params) {
		return get(path, identifier, params);
	}
	
	public JSONObject createObj(JSONObject params) {
		return post(path, params);
	}
	
	public JSONObject updateObj(String identifier, JSONObject params) {
		return put(path, identifier, params);
	}
	
	public JSONObject deleteObj(String identifier) {
		return delete(path, identifier);
	}
	
	public JSONObject schema() {
		return get(path, "schema", null);
	}
}
