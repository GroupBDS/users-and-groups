package org.groupout.users_and_groups.classes;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

public class TokenManager {

	private static final String USER_TOKEN_TABLE = "user_tokens";

	void saveTokenForUser(String token, String userId, String expiresOn) {
		try {
			DynamoDB dynamoDB = new DynamoDB(
					new AmazonDynamoDBClient(new ProfileCredentialsProvider()).withRegion(Regions.US_WEST_2));
			Table table = dynamoDB.getTable(USER_TOKEN_TABLE);

			Item item = new Item().withPrimaryKey("user_id", userId).withString("token", token).withString("expires_on",
					expiresOn);

			PutItemOutcome outcome = table.putItem(item);
			PutItemResult result = outcome.getPutItemResult();
		} catch (Exception e) {
			throw e;
		}
	}
}
