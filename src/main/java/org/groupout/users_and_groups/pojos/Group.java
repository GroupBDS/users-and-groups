package org.groupout.users_and_groups.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Group {
	@XmlElement public String id;
	@XmlElement public String name;
	@XmlElement public String description;
	@XmlElement public String admin;
	@XmlElement public String[] members;
}
