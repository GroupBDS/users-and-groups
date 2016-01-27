package org.groupout.users_and_groups.factories;

import java.sql.ResultSet;

import org.groupout.users_and_groups.classes.JDBCDataManager;
import org.groupout.users_and_groups.jdbc.pojos.User;
import org.groupout.users_and_groups.utils.Constants;
import org.groupout.users_and_groups.utils.IdGenerator;

public class UserFactory {

	/**
	 * Method that creates a new User object and sets its record id
	 * @return User object with recId set
	 */
	public static User createNewUser() {
		
		User user = new User();
		String recId = IdGenerator.generateId();
		user.setRecId(recId);
		return user;
	}
	
	public static User loadUser(String recId) {
		
		JDBCDataManager dataManager = new JDBCDataManager();
		dataManager.setTableName(Constants.USER_TABLE);
		ResultSet resultSet = dataManager.getByRecId(recId);
		
		User user = new User();
		try {
			user.setRecId(resultSet.getString("rec_id"));
			user.setActive(resultSet.getBoolean("active"));
			user.setEmailAddress(resultSet.getString("email_address"));
			user.setFirstName(resultSet.getString("first_name"));
			user.setLastName(resultSet.getString("last_name"));
			user.setRegisteredOn(resultSet.getString("registered_on"));
			user.setPassword(resultSet.getString("password"));
		} catch(Exception e) {
			System.out.println("Error loading the user");
			e.printStackTrace();
		} finally {
			dataManager.closeConnection();
		}
		
		return user;
	}
	
}
