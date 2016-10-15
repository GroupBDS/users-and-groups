package org.groupout.users_and_groups.pojos;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.groupout.users_and_groups.classes.DynamoDBDataRecord;
import org.groupout.users_and_groups.interfaces.DataModel;

@XmlRootElement
public class User extends DynamoDBDataRecord implements DataModel {
	@XmlElement public String firstName;
	@XmlElement public String lastName;
	@XmlElement public String phoneNumber;
	@XmlElement public String emailAddress;
	@XmlElement public String dateOfBirth;
	@XmlElement public String[] groups;
	
	private static final String USER_TABLE = "Users";
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		setValue("first_name", firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		setValue("last_name", lastName);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		setValue("phone_number", phoneNumber);
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		setValue("email_address", emailAddress);
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		setValue("date_of_birth", dateOfBirth);
	}
	
	/**
	 * Loads attributeMap in parent class so that we can insert the record into the database
	 */
	public void loadVariableMap() {
		setTableName(USER_TABLE);
		setValue("first_name", getFirstName());
		setValue("last_name", getLastName());
		setValue("phone_number", getPhoneNumber());
		setValue("email_address", getEmailAddress());
		setValue("date_of_birth", getDateOfBirth());
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", dateOfBirth=" + dateOfBirth + ", groups="
				+ Arrays.toString(groups) + "]";
	}
}
