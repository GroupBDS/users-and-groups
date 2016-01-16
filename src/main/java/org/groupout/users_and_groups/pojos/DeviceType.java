package org.groupout.users_and_groups.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="device_type")
public class DeviceType {

	private String typeId;
	private String type;
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
