package org.groupout.users_and_groups.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="group")
public class Group {

	private String groupId;
	private String name;
	private int memberCount;
	private String createdOn;
	private String lastActivityOn;
	private String description;
	private boolean isActive;
	private String messageBlob;
	private GroupType groupType;
	private User primaryAdmin;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getLastActivityOn() {
		return lastActivityOn;
	}
	public void setLastActivityOn(String lastActivityOn) {
		this.lastActivityOn = lastActivityOn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getMessageBlob() {
		return messageBlob;
	}
	public void setMessageBlob(String messageBlob) {
		this.messageBlob = messageBlob;
	}
	public GroupType getGroupType() {
		return groupType;
	}
	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}
	public User getPrimaryAdmin() {
		return primaryAdmin;
	}
	public void setPrimaryAdmin(User primaryAdmin) {
		this.primaryAdmin = primaryAdmin;
	}
}
