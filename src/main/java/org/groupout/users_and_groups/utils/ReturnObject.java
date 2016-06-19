package org.groupout.users_and_groups.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
		this.returnValueMap.put(statusKey, Constants.SUCCESS);
	}
	
	public void setStatusFailure() {
		this.returnValueMap.put(statusKey, Constants.FAILURE);
	}
	
	public void setMessage(String message) {
		this.returnValueMap.put(messageKey, message);
	}
	
	public JsonObject getJSON() {
		
		JsonObjectBuilder returnJSONBuilder = Json.createObjectBuilder();
		Iterator keyIterator = this.returnValueMap.entrySet().iterator();
		while (keyIterator.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>)keyIterator.next();
			System.out.println("Key : " + entry.getKey() + ", value : " + entry.getValue());
			returnJSONBuilder.add(entry.getKey(), entry.getValue());
		}
		
		return returnJSONBuilder.build();
	}
}
