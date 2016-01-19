package org.groupout.users_and_groups.jdbc.pojos;

import org.groupout.users_and_groups.classes.RecordManager;
import org.groupout.users_and_groups.utils.Constants;

public class User extends RecordManager {

	public User() {
		super(Constants.USER_TABLE);
	}
}
