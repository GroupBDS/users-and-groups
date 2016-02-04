package org.groupout.users_and_groups.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.groupout.users_and_groups.classes.DeviceCategoryManager;
import org.groupout.users_and_groups.classes.DeviceTypeManager;
import org.groupout.users_and_groups.jdbc.pojos.DeviceCategory;
import org.groupout.users_and_groups.jdbc.pojos.DeviceType;

@Path("/device")
public class Devices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/categories")
	public List<DeviceCategory> getDeviceCategories() {

		List<DeviceCategory> deviceCategoryList = new ArrayList<DeviceCategory>();
		try {
			deviceCategoryList = DeviceCategoryManager.getDeviceCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deviceCategoryList;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/types")
	public List<DeviceType> getDeviceTypes() {
		List<DeviceType> deviceTypeList = new ArrayList<DeviceType>();
		try {
			deviceTypeList = DeviceTypeManager.getDeviceTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deviceTypeList;
	}
}
