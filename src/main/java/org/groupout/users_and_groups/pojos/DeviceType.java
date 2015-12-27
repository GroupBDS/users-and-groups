package org.groupout.users_and_groups.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="device_type")
public class DeviceType {

	private String typeId;
	private String deviceType;
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
}
