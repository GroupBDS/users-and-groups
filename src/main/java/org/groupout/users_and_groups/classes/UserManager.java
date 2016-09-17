package org.groupout.users_and_groups.classes;

import org.groupout.users_and_groups.pojos.User;
import org.groupout.users_and_groups.utils.ReturnObject;
import org.groupout.users_and_groups.utils.UtilConstants;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

public class UserManager {

	private static final String USER_TABLE = "Users";

	public ReturnObject registerUser(User user) {
		
		ReturnObject returnObject = new ReturnObject();
		try {

			DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()).withRegion(Regions.US_WEST_2));
			Table table = dynamoDB.getTable(USER_TABLE);

			Item item = new Item()
					.withPrimaryKey("phone_number", user.phoneNumber)
					.withString("first_name", user.firstName)
					.withString("last_name", user.lastName)
					.withString("email_address", user.emailAddress)
					.withString("date_of_birth", user.dateOfBirth);

			PutItemOutcome outcome = table.putItem(item);
			PutItemResult result = outcome.getPutItemResult();
			returnObject.setMessage(result.toString());
		} catch (Exception e) {
			returnObject.setStatus(UtilConstants.FAILURE);
			returnObject.setMessage(e.getMessage());
		}

		return returnObject;
	}

}
