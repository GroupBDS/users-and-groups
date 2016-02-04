package org.groupout.users_and_groups.jdbc.pojos;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User<T> {

	@XmlElement
	public String recId;
	@XmlElement
	public String password;
	@XmlElement
	public boolean active;
	@XmlElement
	public String registeredOn;
	@XmlElement
	public String firstName;
	@XmlElement
	public String lastName;
	@XmlElement
	public String emailAddress;
	@XmlElement
	public Device device;

	// private Device device;
	private Map<String, T> columnValueMap = new HashMap<String, T>();

	public User() {
	}

	public T getRecId() {
		return this.columnValueMap.get("rec_id");
	}

	public void setRecId(T recId) {
		this.columnValueMap.put("rec_id", recId);
	}

	public T getPassword() {
		return this.columnValueMap.get("password");
	}

	public void setPassword(T password) {
		this.columnValueMap.put("password", password);
	}

	public T isActive() {
		return this.columnValueMap.get("active");
	}

	public void setActive(T active) {
		this.columnValueMap.put("active", active);
	}

	public T getRegisteredOn() {
		return this.columnValueMap.get("registered_on");
	}

	public void setRegisteredOn(T registeredOn) {
		this.columnValueMap.put("registered_on", registeredOn);
	}

	public T getFirstName() {
		return this.columnValueMap.get("first_name");
	}

	public void setFirstName(T firstName) {
		this.columnValueMap.put("first_name", firstName);
	}

	public T getLastName() {
		return this.columnValueMap.get("last_name");
	}

	public void setLastName(T lastName) {
		this.columnValueMap.put("last_name", lastName);
	}

	public T getEmailAddress() {
		return this.columnValueMap.get("email_address");
	}

	public void setEmailAddress(T emailAddress) {
		this.columnValueMap.put("email_address", emailAddress);
	}

	public Map<String, T> getColumnValueMap() {
		return this.columnValueMap;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
}
