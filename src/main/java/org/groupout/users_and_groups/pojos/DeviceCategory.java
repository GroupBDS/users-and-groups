package org.groupout.users_and_groups.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="device_category")
public class DeviceCategory {

	private String categoryId;
	private String category;
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
