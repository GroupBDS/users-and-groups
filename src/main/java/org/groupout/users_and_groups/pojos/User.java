package org.groupout.users_and_groups.pojos;

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
}
