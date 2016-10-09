package org.groupout.users_and_groups.classes;

import java.util.Map;

import org.groupout.users_and_groups.pojos.User;
import org.groupout.users_and_groups.utils.ReturnObject;
import org.groupout.users_and_groups.utils.UtilConstants;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

public class UserManager {

	private static final String USER_TABLE = "Users";
	private AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(new ProfileCredentialsProvider())
			.withRegion(Regions.US_WEST_2);

	public ReturnObject registerUser(User user) {

		ReturnObject returnObject = new ReturnObject();
		try {

			DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
			Table table = dynamoDB.getTable(USER_TABLE);

			Item item = new Item().withPrimaryKey("phone_number", user.phoneNumber)
					.withString("first_name", user.firstName).withString("last_name", user.lastName)
					.withString("email_address", user.emailAddress).withString("date_of_birth", user.dateOfBirth);

			PutItemOutcome outcome = table.putItem(item);
			PutItemResult result = outcome.getPutItemResult();
			returnObject.setMessage(result.toString());
		} catch (Exception e) {
			returnObject.setStatus(UtilConstants.FAILURE);
			returnObject.setMessage(e.getMessage());
		}

		return returnObject;
	}

	/**
	 * 
	 * @param userId
	 *            Unique identifier for user (phone number in this case)
	 * @return user if exists in database, null if not found
	 */
	public User getUser(String userId) {

		Item item = null;

		DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
		Table table = dynamoDB.getTable(USER_TABLE);

		PrimaryKey primaryKey = new PrimaryKey();
		primaryKey = primaryKey.addComponent("phone_number", userId);
		try {
			item = table.getItem(primaryKey);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return getUserFromItem(item);
	}

	private User getUserFromItem(Item item) {
		
		User user = null;
		if (item == null)
			return user;
		
		user = new User();
		Map<String, Object> itemMap = item.asMap();
		user.firstName = (String) itemMap.get("first_name");
		user.lastName = (String) itemMap.get("last_name");
		user.phoneNumber = (String) itemMap.get("phone_number");
		user.emailAddress = (String) itemMap.get("email_address");
		user.dateOfBirth = (String) itemMap.get("date_of_birth");
		
		return user;
	}
}
