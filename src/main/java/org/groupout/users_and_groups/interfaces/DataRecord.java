package org.groupout.users_and_groups.interfaces;

import org.json.simple.JSONObject;

public interface DataRecord<T> {
	public T getId();
	public void setValue(String columnName, T value);
	public T getValue(String columnName);
	public JSONObject getJSON();
	public T insert();
	public boolean deleteRecord();
	public void initializeRecordById(T recordId);
}
