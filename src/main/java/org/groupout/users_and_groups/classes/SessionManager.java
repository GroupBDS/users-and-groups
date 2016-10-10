package org.groupout.users_and_groups.classes;

import org.groupout.users_and_groups.pojos.User;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;

public class SessionManager {

	private static String TOKEN_TABLE = "user_tokens";
	private AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(new ProfileCredentialsProvider())
			.withRegion(Regions.US_WEST_2);
	
	private String sessionToken;
	public boolean userSessionActive(User user) {
		
		Item item = null;
		DynamoDB dynamoDB = new DynamoDB(dynamoDBClient); 
		Table table = dynamoDB.getTable(TOKEN_TABLE);
		
		PrimaryKey primaryKey = new PrimaryKey();
		primaryKey.addComponent("user_id", user.phoneNumber);
		
		
		try {
			item = table.getItem(primaryKey);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (item == null)
			return false;
		
		sessionToken = item.getString("token");
		
		// TODO: Add logic to verify if the token did not expire
		return true;
	}
	
	public String getSessionToken() {
		return sessionToken;
	}
	
	public void clearUserSession() {
		// Delete the token and sessions from database
	}
	
}
