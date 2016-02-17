package org.groupout.users_and_groups.classes;

import org.groupout.users_and_groups.jdbc.pojos.User;
import org.groupout.users_and_groups.utils.Constants;
import org.groupout.users_and_groups.utils.IdGenerator;

public class UserManager {

	public UserManager() {
		
	}

	/**
	 * 
	 * @param user
	 *            User that needs to be inserted into the database
	 * @return record id of the inserted id if successfully inserted, else ""
	 */
	public String insertUserRecord(User user) {

		StringBuilder recIdBuilder = new StringBuilder();
		String recId = IdGenerator.generateId();
		JDBCDataManager dataManager = new JDBCDataManager(Constants.USER_TABLE);
		
		dataManager.setValue("rec_id", recId);
		dataManager.setValue("first_name", user.firstName);
		dataManager.setValue("last_name", user.lastName);
		dataManager.setValue("password", user.password);
		dataManager.setValue("registered_on", user.registeredOn);
		dataManager.setValue("active", user.active);
		dataManager.setValue("email_address", user.emailAddress);
		dataManager.setValue("primary_device", user.device.recId);
		dataManager.insert();
		if (dataManager.closeConnection())
			recIdBuilder.append(recId);
		
		return recIdBuilder.toString();
	}	
}
