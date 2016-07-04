package org.groupout.users_and_groups.classes;

import java.util.HashMap;
import java.util.Map;

import org.groupout.users_and_groups.interfaces.DataRecord;
import org.json.simple.JSONObject;

public class RDBDataRecord<T> implements DataRecord<T> {

	private T recordId;
	private Map<String, T> columnValueMap;
	
	public RDBDataRecord() {
		columnValueMap = new HashMap<String, T>();
	}
	
	public T getId() {
		return this.recordId;
	}
	
	public void setId(T t) {
		this.recordId = t;
	}
	
	public void setValue(String columnName, T value) {
		columnValueMap.put(columnName, value);
	}
	
	public T getValue(String columnName) {
		return columnValueMap.get(columnName);
	}
	
	// TODO : Implement the following functions
	public JSONObject getJSON() {
		return new JSONObject();
	}
	
	public T insert() {
		return this.recordId;
	}
	
	public boolean deleteRecord() {
		return true;
	}
	
	public void initializeRecordById(T recordId) {
		
	}
}
