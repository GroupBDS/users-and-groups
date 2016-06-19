package org.groupout.users_and_groups.utils;


import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class DBUtil {

	private static RethinkDB r = RethinkDB.r;
	public static String createTable(String tableName) throws Exception {
		try {
			String hostName = getHostName();
			int port = getPortNumber();
			
			Connection connection = createConnection(hostName, port);
		
			
			
		} catch(Exception exception) {
			System.out.println(exception.getMessage());
			return "failure";
		}
		
		return "success";
	}
	
	private static Connection createConnection(String hostName, int port) {
		return r.connection().hostname(hostName).port(port).connect();
	}
	
	private static String getHostName() {
		return "localhost";
	}
	
	private static int getPortNumber() {
		return 8090;
	}
}
