package org.groupout.users_and_groups.utils;

public class UtilConstants {

	// Table names
	public static final String DEVICE_TYPE_TABLE        = "device_type";
	public static final String DEVICE_CATEGORY_TABLE    = "device_category";
	public static final String DEVICE_TABLE             = "device";
	public static final String GROUP_TABLE              = "group";
	public static final String GROUP_TYPE_TABLE         = "group_type";
	public static final String USER_TABLE               = "user";
	public static final String MAP_USER_DEVICE          = "map_user_device_details";
	public static final String USER_VERIFICATION_TABLE  = "user_verification_table"; 
	
	// Device types
	public static final String CELLPHONE = "cellphone";
	public static final String TABLET    = "tablet";
	
	// Constants related to device verification
	public static final long CODE_EXPIRY_TIME = 300000;
	public static final int  MAX_FAILED_ATTEMPTS = 3;
	
	// These statuses can be used anywhere
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
}
