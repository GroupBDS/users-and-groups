package org.groupout.users_and_groups.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="device")
public class Device {
	
	private String deviceId;
	private String countryCode;
	private String phoneNumber;
	private String registeredOn;
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getRegisteredOn() {
		return registeredOn;
	}
	
	public void setRegisteredOn(String registeredOn) {
		this.registeredOn = registeredOn;
	}
}
