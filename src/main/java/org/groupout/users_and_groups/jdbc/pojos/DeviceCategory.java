package org.groupout.users_and_groups.jdbc.pojos;

import org.groupout.users_and_groups.classes.RecordManager;
import org.groupout.users_and_groups.utils.Constants;

public class DeviceCategory extends RecordManager {
	
	public DeviceCategory() {
		super(Constants.DEVICE_CATEGORY_TABLE);
	}
}
