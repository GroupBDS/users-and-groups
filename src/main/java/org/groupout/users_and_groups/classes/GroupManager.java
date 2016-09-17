package org.groupout.users_and_groups.classes;

import java.util.HashSet;
import java.util.Set;

import org.groupout.users_and_groups.pojos.Group;
import org.groupout.users_and_groups.pojos.User;
import org.groupout.users_and_groups.utils.RecordHelper;
import org.groupout.users_and_groups.utils.ReturnObject;
import org.groupout.users_and_groups.utils.UtilConstants;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.AttributeUpdate;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

public class GroupManager {

	private static final String GROUP_TABLE = "Groups";
	private ReturnObject returnObject;
	
	/**
	 * 
	 * @param group Group object that needs to be created
	 * @return ReturnObject that contains status and message of the operation
	 */
	public ReturnObject createGroup(Group group) {
		
		returnObject = new ReturnObject();
		try {
			Set<String> memberSet = new HashSet<>();
			memberSet.add(group.admin);
			DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()).withRegion(Regions.US_WEST_2));
			Table table = dynamoDB.getTable(GROUP_TABLE);

			Item item = new Item()
					.withPrimaryKey("id", RecordHelper.createUniqueIdentifier())
					.withString("name", group.name)
					.withString("description", group.description)
					.withString("admin", group.admin)
					.withStringSet("members", memberSet);

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
	 * @param userKey phoneNumber of the user to be added to the group, primary key
	 * @param group Group that the user should be added to
	 * @return ReturnObject that contains status and message of the operation
	 */
	public ReturnObject addUserToGroup(String userKey, Group group) {
		
		returnObject = new ReturnObject();
		try {
			DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()).withRegion(Regions.US_WEST_2));
			Table table = dynamoDB.getTable(GROUP_TABLE);
		
			PrimaryKey primaryKey = new PrimaryKey();
			primaryKey.addComponent("id", group.id);
			// Item item = table.getItem(primaryKey);
			
			AttributeUpdate attributeUpdate = new AttributeUpdate("members");
			attributeUpdate.addElements(userKey);
			table.updateItem(primaryKey, attributeUpdate);
			
			
		} catch(Exception e) {
			returnObject.setMessage(UtilConstants.FAILURE);
			returnObject.setMessage(e.getMessage());
		}
		
		return new ReturnObject();
	}
	
}
