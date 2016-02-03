package org.groupout.users_and_groups.classes;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.groupout.users_and_groups.jdbc.pojos.DeviceType;
import org.groupout.users_and_groups.utils.Constants;

public class DeviceTypeManager {
	public static List<DeviceType> getDeviceTypes() {

		JDBCDataManager dataManager = new JDBCDataManager(Constants.DEVICE_TYPE_TABLE);
		;
		ResultSet resultSet;
		List<DeviceType> deviceTypeList = new ArrayList<DeviceType>();
		DeviceType deviceType;
		try {
			resultSet = dataManager.getAllRecordsInTable();
			String recId;
			String category;

			while (resultSet.next()) {
				recId = resultSet.getString("rec_id");
				category = resultSet.getString("device_type");
				deviceType = new DeviceType();
				deviceType.recId = recId;
				deviceType.type = category;
				deviceTypeList.add(deviceType);
			}
		} catch (Exception e) {
			System.out.println("Error in DeviceTypeManager.getDeviceTypes()");
			e.printStackTrace();
		} finally {
			dataManager.closeConnection();
		}
		return deviceTypeList;
	}
}
