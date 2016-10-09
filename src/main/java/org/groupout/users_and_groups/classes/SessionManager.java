package org.groupout.users_and_groups.classes;

import org.groupout.users_and_groups.pojos.User;

public class SessionManager {

	private String sessionToken;
	public boolean userSessionActive(User user) {
		
		
		
		
		return true;
		
		
	}
	
	public String getSessionToken() {
		return sessionToken;
	}
	
	public void clearUserSession() {
		// Delete the token and sessions from database
	}
	
}
