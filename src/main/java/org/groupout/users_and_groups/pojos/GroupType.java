package org.groupout.users_and_groups.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="group_type")
public class GroupType {

	private String groupTypeId;
	private String type;
	private String description;
	
	public String getGroupTypeId() {
		return groupTypeId;
	}
	public void setGroupTypeId(String groupTypeId) {
		this.groupTypeId = groupTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
