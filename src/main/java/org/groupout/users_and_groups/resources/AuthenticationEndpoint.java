package org.groupout.users_and_groups.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.groupout.users_and_groups.classes.TokenGenerator;

@Path("/authenticate")
public class AuthenticationEndpoint {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("username") String userName, @FormParam("password") String password) {
		
		try {
			
			authenticate(userName, password);
			
			String token = TokenGenerator.getTokenForUser(userName, 1000);
			
			return Response.ok(token).build();
		} catch(Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	
	private void authenticate(String userName, String password) throws Exception {
		return;
	}
}
