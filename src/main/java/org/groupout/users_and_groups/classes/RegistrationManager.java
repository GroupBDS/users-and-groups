package org.groupout.users_and_groups.classes;

import org.groupout.users_and_groups.jdbc.pojos.User;
import org.groupout.users_and_groups.utils.Constants;

/**
 * This class manages the user registration and related things
 * @author shravan
 *
 */
public class RegistrationManager {

	public RegistrationManager() {
		
	}
	
	public ReturnObject registerUser(User user) {
		
		ReturnObject returnObject = new ReturnObject();
		returnObject.status = Constants.SUCCESS;
		returnObject.message = "Successfully registered user";
		JDBCDataManager dataManager = new JDBCDataManager(Constants.MAP_USER_DEVICE);
		try {
			// Insert Device first
			String deviceId = new DeviceManager().insertDeviceRecord(user.device);
			
			// Create a user record
			user.device.recId = deviceId;
			String userRecId = new UserManager().insertUserRecord(user);
			
			// Create a mapping for user vs device
			dataManager.setValue("user_id", userRecId);
			dataManager.setValue("device_id", deviceId);
			dataManager.setValue("active", true);
			dataManager.insert();
			
			// Populate a record in the user_verification_status table
			UserVerificationStatusManager userVerifStatusManager = new UserVerificationStatusManager();
			userVerifStatusManager.createUserVerificationStatusRecord(userRecId, deviceId);
			
		} catch(Exception e) {
			System.out.println("Error registering user");
			e.printStackTrace();
			returnObject.status = Constants.FAILURE;
			returnObject.message = e.getMessage();
		} finally {
			dataManager.closeConnection();
		}
		
		return returnObject;
	}
}
