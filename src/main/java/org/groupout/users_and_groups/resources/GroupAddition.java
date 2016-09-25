package org.groupout.users_and_groups.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.groupout.users_and_groups.classes.GroupManager;
import org.groupout.users_and_groups.pojos.Group;

@Path("/group")
public class GroupAddition {

	@POST
	@Path("/create-group")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createGroup(Group group) {
		return new GroupManager().createGroup(group).getJSON().toString();
	}
	
	@PUT
	@Path("/add-user-to-group")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUserToGroup(@PathParam("user") String userId, @PathParam("group") String groupId) {
		return new GroupManager().addUserToGroup(userId, groupId).getJSON().toString();
	}
}
