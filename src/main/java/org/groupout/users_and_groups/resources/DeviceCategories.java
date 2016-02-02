package org.groupout.users_and_groups.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.groupout.users_and_groups.classes.DeviceCategoryManager;
import org.groupout.users_and_groups.jdbc.pojos.DeviceCategory;

@Path("/device")
public class DeviceCategories {

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
}
