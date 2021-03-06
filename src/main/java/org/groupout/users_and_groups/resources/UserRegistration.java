package org.groupout.users_and_groups.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.groupout.users_and_groups.classes.UserManager;
import org.groupout.users_and_groups.pojos.User;

@Path("/registerUser")
public class UserRegistration {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerUser(User user) {
		return new UserManager().registerUser(user).getJSON().toString();
	}
}
