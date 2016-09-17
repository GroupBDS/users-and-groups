package org.groupout.users_and_groups.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.groupout.users_and_groups.classes.GroupManager;
import org.groupout.users_and_groups.pojos.Group;

@Path("/createGroup")
public class GroupAddition {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createGroup(Group group) {
		return new GroupManager().createGroup(group).getJSON().toString();
	}
}
