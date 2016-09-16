package org.groupout.users_and_groups.classes;

import java.util.HashSet;
import java.util.Set;

import org.groupout.users_and_groups.pojos.Group;
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

public class GroupManager {

	private static final String GROUP_TABLE = "Groups";
	private String id;
	
	public ReturnObject createGroup(Group group) {
		
		ReturnObject returnObject = new ReturnObject();
		returnObject.setStatus(UtilConstants.SUCCESS);
		try {

			id = "asfff";
			Set<String> memberSet = new HashSet<>();
			memberSet.add(group.admin);
			DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()).withRegion(Regions.US_WEST_2));
			Table table = dynamoDB.getTable(GROUP_TABLE);

			Item item = new Item()
					.withPrimaryKey("id", id)
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
	
}
