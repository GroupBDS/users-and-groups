package org.groupout.users_and_groups.jdbc.pojos;

import org.groupout.users_and_groups.classes.JDBCDataManager;
import org.groupout.users_and_groups.utils.IdGenerator;
import org.groupout.users_and_groups.utils.Constants;

public class DeviceType extends JDBCDataManager {

	String recId;
	public DeviceType() {
		super(Constants.DEVICE_TYPE_TABLE);
		recId = IdGenerator.generateId();
		setValue("rec_id", recId);
	}
}
