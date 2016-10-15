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

public class DynamoDBDataRecord implements DataRecord<String> {

	private AmazonDynamoDBClient dynamoDBClient;
	private String tableName;
	private Map<String, String> attributeMap = new HashMap<>();
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
	
	public String getId() {
		return "Success";
	}
	
	public void setValue(String columnName, String value) {
		attributeMap.put(columnName, value);
	}
	
	public String getValue(String columnName) {
		return attributeMap.get(columnName);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSON() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(attributeMap);
		
		return jsonObject;
	}
	
	public String insert() {
		PutItemResult result = null;
		try{
			Item item = getItemToInsert();
			PutItemOutcome outcome = table.putItem(item);
			result = outcome.getPutItemResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
	
	public boolean deleteRecord() {
		return true;
	}
	
	public void initializeRecordById(String recordId) {
		
	}
	
	private Item getItemToInsert() {
		Item item = new Item();
		Iterator<Entry<String, String>> iterator = attributeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>)iterator.next();
			item.withString(entry.getKey(), entry.getValue());
		}
		
		return item;
	}
	
	private void setEnvironmentParameters() {
		dynamoDBClient = new AmazonDynamoDBClient(new ProfileCredentialsProvider()).withRegion(Regions.US_WEST_2);
		dynamoDB = new DynamoDB(dynamoDBClient);
		table = dynamoDB.getTable(tableName);
	}
}
