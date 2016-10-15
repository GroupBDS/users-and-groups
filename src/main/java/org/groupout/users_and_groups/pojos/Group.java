package org.groupout.users_and_groups.pojos;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.groupout.users_and_groups.classes.DynamoDBDataRecord;
import org.groupout.users_and_groups.interfaces.DataModel;

@XmlRootElement
public class Group extends DynamoDBDataRecord implements DataModel {
	@XmlElement public String id;
	@XmlElement public String name;
	@XmlElement public String description;
	@XmlElement public String admin;
	@XmlElement public String[] members;
	
	private static final String GROUP_TABLE = "Groups";
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
		setValue("id", id);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setValue("name", name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		setValue("description", description);
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
		setValue("admin", admin);
	}
	
	public void loadVariableMap() {
		setTableName(GROUP_TABLE);
		setValue("id", getId());
		setValue("name", getName());
		setValue("description", getDescription());
		setValue("admin", getAdmin());
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", description=" + description + ", admin=" + admin + ", members="
				+ Arrays.toString(members) + "]";
	}
}
