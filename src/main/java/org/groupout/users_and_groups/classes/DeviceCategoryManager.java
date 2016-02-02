package org.groupout.users_and_groups.classes;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.groupout.users_and_groups.jdbc.pojos.DeviceCategory;
import org.groupout.users_and_groups.utils.Constants;

public class DeviceCategoryManager {

	public static List<DeviceCategory> getDeviceCategories() {

		JDBCDataManager dataManager = new JDBCDataManager(Constants.DEVICE_CATEGORY_TABLE);;
		ResultSet resultSet;
		List<DeviceCategory> deviceCategoryList = new ArrayList<DeviceCategory>();
		DeviceCategory deviceCategory;
		try { 
			resultSet = dataManager.getAllRecordsInTable();
			String recId;
			String category;

			while (resultSet.next()) {
				recId = resultSet.getString("rec_id");
				category = resultSet.getString("category");
				deviceCategory = new DeviceCategory();
				deviceCategory.setRecId(recId);
				deviceCategory.setCategory(category);
				deviceCategoryList.add(deviceCategory);
			}
		} catch (Exception e) {
			System.out.println("Error in DeviceCategory.getDeviceCategories()");
			e.printStackTrace();
		} finally {
			dataManager.closeConnection();
		}
		return deviceCategoryList;
	}
}
