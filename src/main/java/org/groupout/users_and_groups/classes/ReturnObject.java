package org.groupout.users_and_groups.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReturnObject {

	@XmlElement public String status;
	@XmlElement public String message;
}
