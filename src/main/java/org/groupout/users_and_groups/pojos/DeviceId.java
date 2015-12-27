package org.groupout.users_and_groups.pojos;

import java.io.Serializable;

public class DeviceId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String countryCode;
	private String phoneNumber;
	
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
}
