package org.groupout.users_and_groups.jdbc.pojos;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User<T> {

	private String recId;
	private String password;
	private boolean active;
	private String registeredOn;
	private String firstName;
	private String lastName;
	private String emailAddress;
	//private Device device;
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

	/*public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}*/
	
	/*public void getModelById(String recId) {
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
	} */
}
