package org.groupout.users_and_groups.jdbc.pojos;

import java.sql.ResultSet;

import javax.xml.bind.annotation.XmlRootElement;

import org.groupout.users_and_groups.classes.RecordManager;
import org.groupout.users_and_groups.utils.Constants;

@XmlRootElement
public class User extends RecordManager {

	private String recId;
	private String password;
	private boolean active;
	private String registeredOn;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Device device;
	
	// Constructor
	public User() {
		super(Constants.USER_TABLE);
	}
		
	public String getRecId() {
		return recId;
	}

	public void setRecId(String recId) {
		this.recId = recId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(String registeredOn) {
		this.registeredOn = registeredOn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	
	public void getModelById(String recId) {
		try {
			ResultSet resultSet = this.getByRecId(recId);
			if (resultSet.next()) {
				this.setRecId(resultSet.getString("rec_id"));
				this.setActive(resultSet.getBoolean("active"));
				this.setEmailAddress(resultSet.getString("email_address"));
				this.setFirstName(resultSet.getString("first_name"));
				this.setLastName(resultSet.getString("last_name"));
				this.setRegisteredOn(resultSet.getString("registered_on"));
			}
		} catch(Exception e) {
			System.out.println("Error getting model by id");
			e.printStackTrace();
		}
	}
}
