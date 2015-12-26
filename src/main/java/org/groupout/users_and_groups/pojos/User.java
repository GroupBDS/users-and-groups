package org.groupout.users_and_groups.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	private String userId;
	private String password;
	private boolean active;
	private String registeredOn;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Device primaryDevice;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public Device getPrimaryDevice() {
		return primaryDevice;
	}

	public void setPrimaryDevice(Device primaryDevice) {
		this.primaryDevice = primaryDevice;
	}
}
