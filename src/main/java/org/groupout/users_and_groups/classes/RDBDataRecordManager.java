package org.groupout.users_and_groups.classes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.json.simple.JSONObject;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class RDBDataRecordManager {

	private static RethinkDB r = RethinkDB.r;
	private String dbHost;
	private int dbPort;
	private String dbName;
	private String tableName;
	Connection connection;
	
	public RDBDataRecordManager(String tableName) {
		this.tableName = tableName;
		initializeDatabaseParameters();
		createConnection();
	}
	
	public void closeConnection() {
		this.connection.close();
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public long insert(JSONObject insertBlob) {
		try {
		String string = r.table(this.tableName).insert(this.r.hashMap("title", "Pulp Fiction 2")).run(this.connection);
		return 2;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 2;
	}
	
	private void initializeDatabaseParameters() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(Constants.DB_PROPERTIES_FILE);
			properties.load(inputStream);
			
			this.dbHost = properties.getProperty("host");
			this.dbPort = Integer.parseInt(properties.getProperty("port"));
			this.dbName = properties.getProperty("name");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void createConnection() {
		r.connection().hostname(this.dbHost).port(this.dbPort).connect();
	}
}
