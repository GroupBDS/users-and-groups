package org.groupout.users_and_groups.jdbc.pojos;

import org.groupout.users_and_groups.classes.RecordManager;
import org.groupout.users_and_groups.utils.Constants;

public class Device extends RecordManager {

	public Device() {
		super(Constants.DEVICE_TABLE);
	}
}
