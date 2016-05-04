package org.groupout.users_and_groups.classes;

import org.groupout.users_and_groups.jdbc.pojos.Device;
import org.groupout.users_and_groups.utils.Constants;
import org.groupout.users_and_groups.utils.IdGenerator;

public class DeviceManager {

	public DeviceManager() {

	}

	/**
	 * 
	 * @param device
	 *            Device that needs to be inserted into the database
	 * @return record id of the inserted id if successfully inserted, else ""
	 */
	public String insertDeviceRecord(Device device) {

		StringBuilder recIdBuilder = new StringBuilder();
		String recId = IdGenerator.generateId();
		JDBCDataManager<String> dataManager = new JDBCDataManager<String>(Constants.DEVICE_TABLE);
		
		dataManager.setValue("rec_id", recId);
		dataManager.setValue("device_type", device.deviceType.recId);
		dataManager.setValue("device_category", device.deviceCategory.recId);
		dataManager.setValue("registered_on", device.registeredOn);
		dataManager.setValue("country_code", device.countryCode);
		dataManager.setValue("phone_number", device.phoneNumber);
		dataManager.insert();
		if (dataManager.closeConnection())
			recIdBuilder.append(recId);
		
		device.recId = recId;
		return recIdBuilder.toString();
	}

}
