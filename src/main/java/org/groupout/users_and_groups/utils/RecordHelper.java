package org.groupout.users_and_groups.utils;

import java.util.UUID;

public class RecordHelper {

	public static String createUniqueIdentifier() {
		return UUID.randomUUID().toString();
	}
}
