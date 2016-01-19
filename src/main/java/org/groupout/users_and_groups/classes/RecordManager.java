package org.groupout.users_and_groups.classes;

import org.groupout.users_and_groups.utils.IdGenerator;

public class RecordManager extends JDBCDataManager {

	String recId;
	public RecordManager(String tableName) {
		super(tableName);
		recId = IdGenerator.generateId();
		setValue("rec_id", recId);		
	}
}
