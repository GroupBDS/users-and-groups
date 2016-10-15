package org.groupout.users_and_groups.classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.groupout.users_and_groups.interfaces.DataRecord;
import org.json.simple.JSONObject;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

public class DynamoDBDataRecord<T> implements DataRecord <T> {

	private AmazonDynamoDBClient dynamoDBClient;
	private String tableName;
	private Map<String, T> attributeMap = new HashMap<>();
	private DynamoDB dynamoDB;
	private Table table;
	
	public DynamoDBDataRecord(String tableName) {
		setTableName(tableName);
		setEnvironmentParameters();
	}
	
	public DynamoDBDataRecord() {
		setEnvironmentParameters();
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public T getId() {
		return (T)"Success";
	}
	
	public void setValue(String columnName, T value) {
		attributeMap.put(columnName, value);
	}
	
	public T getValue(String columnName) {
		return attributeMap.get(columnName);
	}
	
	public JSONObject getJSON() {
		String jsonString = JSONObject.toJSONString(attributeMap);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(attributeMap);
		
		return jsonObject;
	}
	
	public T insert() {
		try{
			Item item = getItemToInsert();
			PutItemOutcome outcome = table.putItem(item);
			PutItemResult result = outcome.getPutItemResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return getId();
	}
	
	public boolean deleteRecord() {
		return true;
	}
	
	public void initializeRecordById(T recordId) {
		
	}
	
	private Item getItemToInsert() {
		Item item = new Item();
		Iterator<Entry<String, T>> iterator = attributeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, T> entry = (Map.Entry<String, T>)iterator.next();
			item.withString(entry.getKey(), (String)entry.getValue());
		}
		
		return item;
	}
	
	private void setEnvironmentParameters() {
		dynamoDBClient = new AmazonDynamoDBClient(new ProfileCredentialsProvider()).withRegion(Regions.US_WEST_2);
		dynamoDB = new DynamoDB(dynamoDBClient);
		table = dynamoDB.getTable(tableName);
	}
}
