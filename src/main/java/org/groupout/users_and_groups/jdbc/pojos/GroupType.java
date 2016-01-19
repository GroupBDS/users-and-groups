package org.groupout.users_and_groups.jdbc.pojos;

import org.groupout.users_and_groups.classes.RecordManager;
import org.groupout.users_and_groups.utils.Constants;

public class GroupType extends RecordManager {

	public GroupType() {
		super(Constants.GROUP_TYPE_TABLE);
	}
}
