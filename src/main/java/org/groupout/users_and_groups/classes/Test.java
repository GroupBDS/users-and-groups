package org.groupout.users_and_groups.classes;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.DeleteTopicRequest;

public class Test {

	public static void main(String args[]) {
		try {
	
			AmazonSNSClient client = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());
			client.setRegion(Region.getRegion(Regions.US_WEST_2));
			
			/*CreateTopicRequest createTopicRequest = new CreateTopicRequest("TestTopic");
			CreateTopicResult createTopicResult = client.createTopic(createTopicRequest);
			System.out.println(createTopicResult);
			System.out.println("Create topic request : " + client.getCachedResponseMetadata(createTopicRequest)); */
			
			String topicArn = "arn:aws:sns:us-west-2:501686834948:TestTopic";
			DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicArn);
			
			client.deleteTopic(deleteTopicRequest);
			System.out.println(client.getCachedResponseMetadata(deleteTopicRequest));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
