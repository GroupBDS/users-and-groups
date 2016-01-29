package org.groupout.users_and_groups.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.groupout.users_and_groups.classes.JDBCDataManager;
import org.groupout.users_and_groups.classes.ReturnObject;
import org.groupout.users_and_groups.factories.UserFactory;
import org.groupout.users_and_groups.jdbc.pojos.User;
import org.groupout.users_and_groups.utils.Constants;

@Path("/users")
public class Users {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public 	User getUser(@PathParam("id") String recId) {
		
		User user = UserFactory.loadUser(recId);
		return user;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnObject createUser(User user) {
		ReturnObject returnObject = new ReturnObject();
		try {
			JDBCDataManager dataManager = new JDBCDataManager();
			dataManager.setTableName(Constants.USER_TABLE);
			user = UserFactory.createNewUser(user);
			dataManager.insert(user.getColumnValueMap());
			dataManager.closeConnection();
			returnObject.status = "success";
			returnObject.message = "Successfully inserted user " + user.getFirstName();
			return returnObject;
		} catch(Exception e) {
			returnObject.status = "error";
			returnObject.message = e.getMessage();
			return returnObject;
		}
	}
}
