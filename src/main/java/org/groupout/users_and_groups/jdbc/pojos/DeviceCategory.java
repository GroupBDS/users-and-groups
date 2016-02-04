package org.groupout.users_and_groups.jdbc.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceCategory {

	@XmlElement
	public String recId;
	@XmlElement
	public String category;

	public DeviceCategory() {
	}
}
