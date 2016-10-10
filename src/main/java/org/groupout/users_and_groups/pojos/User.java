package org.groupout.users_and_groups.pojos;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	@XmlElement public String firstName;
	@XmlElement public String lastName;
	@XmlElement public String phoneNumber;
	@XmlElement public String emailAddress;
	@XmlElement public String dateOfBirth;
	@XmlElement public String[] groups;
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", dateOfBirth=" + dateOfBirth + ", groups="
				+ Arrays.toString(groups) + "]";
	}
}
