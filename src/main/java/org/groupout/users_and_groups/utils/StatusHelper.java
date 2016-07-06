package org.groupout.users_and_groups.utils;

public class StatusHelper {

	public static ReturnObject createFailureReturnObject(String message) {
		return createReturnObject(UtilConstants.FAILURE, message);
	}
	
	public static ReturnObject createSuccessReturnObject() {
		return createReturnObject(UtilConstants.SUCCESS, "");
	}
	
	private static ReturnObject createReturnObject(String status, String message) {
		ReturnObject returnObject = new ReturnObject();
		returnObject.setStatus(status);
		returnObject.setMessage(message);
		return returnObject;
	}
}
