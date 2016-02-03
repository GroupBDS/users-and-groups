package org.groupout.users_and_groups.jdbc.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceType {

	@XmlElement public String recId;
	@XmlElement public String type;
	
	public DeviceType() {
	}
}
