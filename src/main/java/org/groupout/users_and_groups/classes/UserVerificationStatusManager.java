package org.groupout.users_and_groups.classes;

import java.util.Calendar;
import java.util.Date;

import org.groupout.users_and_groups.utils.Constants;

/**
 * 
 * @author shravan
 * Manager class used to insert/manage records for user verification status
 * Table managed is user_verification_status
 */

public class UserVerificationStatusManager {
	
	private String userId;
	private String deviceId;
	
	public UserVerificationStatusManager() {
		
	}
	
	public boolean createUserVerificationStatusRecord(String userId, String deviceId) {
		try {
			setUserId(userId);
			setDeviceId(deviceId);
		
			JDBCDataManager dataManager = new JDBCDataManager(Constants.USER_VERIFICATION_TABLE);
			dataManager.setValue("status_user", userId);
			dataManager.setValue("status_device", deviceId);
			dataManager.setValue("verfication_code_sent", true);    // TODO: Get rid of this hardcoded value when we have logic to send code
			dataManager.setValue("verified", false);
			dataManager.setValue("verficiation_code", "12345");     // TODO: Have a randon code generator and then get rid of the hardcoded value
			dataManager.setValue("code_expires_on", getExpiresOn().toString());
			dataManager.setValue("failed_attempt_count", 0);
		
			dataManager.insert();
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	private Date getExpiresOn() {
	
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(calendar.getTimeInMillis() + Constants.CODE_EXPIRY_TIME);
		
		return calendar.getTime();
	}
}
