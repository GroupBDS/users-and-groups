package org.groupout.users_and_groups.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.groupout.users_and_groups.factories.UserFactory;
import org.groupout.users_and_groups.jdbc.pojos.User;

@Path("/users")
public class Users {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public 	User getUser(@PathParam("id") String recId) {
		
		User user = UserFactory.loadUser(recId);
		return user;
	}
}
