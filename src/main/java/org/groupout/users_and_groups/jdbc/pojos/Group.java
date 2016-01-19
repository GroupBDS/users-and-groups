package org.groupout.users_and_groups.jdbc.pojos;

import org.groupout.users_and_groups.classes.RecordManager;
import org.groupout.users_and_groups.utils.Constants;

public class Group extends RecordManager {

	public Group() {
		super(Constants.GROUP_TABLE);
	}
}
