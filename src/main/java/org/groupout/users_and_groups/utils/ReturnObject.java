package org.groupout.users_and_groups.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class ReturnObject {

	private Map<String, String> returnValueMap = new HashMap<String, String>();
	private String statusKey = "status";
	private String messageKey = "message";
	
	public ReturnObject() {
		this.returnValueMap.put(statusKey, Constants.SUCCESS);
		this.returnValueMap.put(messageKey, "");
	}
	
	public void setStatusSuccess() {
		setStatus(Constants.SUCCESS);
	}
	
	public void setStatusFailure() {
		setStatus(Constants.FAILURE);
	}
	
	public void setMessage(String message) {
		this.returnValueMap.put(messageKey, message);
	}
	
	public JsonObject getJSON() {
		JsonObjectBuilder returnJSONBuilder = Json.createObjectBuilder();
		for (Entry<String, String> entry : this.returnValueMap.entrySet())
			returnJSONBuilder.add(entry.getKey(), entry.getValue());
		
		return returnJSONBuilder.build();
	}
	
	private void setStatus(String status) {
		this.returnValueMap.put(statusKey, status);
	}	
}
