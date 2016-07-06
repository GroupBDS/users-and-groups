package org.groupout.users_and_groups.classes;

import java.util.HashMap;
import java.util.Map;

import org.groupout.users_and_groups.interfaces.DataRecord;
import org.json.simple.JSONObject;

import com.rethinkdb.net.Connection;

public class RDBDataRecord<T> implements DataRecord<T> {

	private T recordId;
	private String tableName;
	private Map<String, T> columnValueMap;
	private RDBDataRecordManager dataManager;
	
	public RDBDataRecord(String tableName) {
		columnValueMap = new HashMap<String, T>();
		this.tableName = tableName;
		this.dataManager = new RDBDataRecordManager(this.tableName);
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
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", "Pulp Fiction");
		jsonObject.put("content", "Freaking awesome movie");
		
		this.dataManager.insert(jsonObject);
		return this.recordId;
	}
	
	public boolean deleteRecord() {
		return true;
	}
	
	public void initializeRecordById(T recordId) {
		
	}
}
