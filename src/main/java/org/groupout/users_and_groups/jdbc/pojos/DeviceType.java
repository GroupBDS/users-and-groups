package org.groupout.users_and_groups.jdbc.pojos;

import org.groupout.users_and_groups.classes.RecordManager;
import org.groupout.users_and_groups.utils.Constants;

public class DeviceType extends RecordManager {

	public DeviceType() {
		super(Constants.DEVICE_TYPE_TABLE);
	}
}
