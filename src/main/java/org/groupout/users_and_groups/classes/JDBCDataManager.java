package org.groupout.users_and_groups.classes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

public class JDBCDataManager<T> implements DataManager<T> {
	
	private Map<String, T> columnValueMap;
	private String tableName;
	private Connection connection;
	private Statement statement;
	private String driver;
	private String dbUrl;
	private String userName;
	private String password;
	
	public JDBCDataManager(String tableName) {
		this.tableName = tableName;
		this.initializeDatabaseProperties();
		this.initializeConnection();
	}
	
	public void setValue(String column, T value) {
		this.columnValueMap.put(column, value);
	}
	
	public T getValue(String column) {
		return this.columnValueMap.get(column);
	}
	
	public String insert() {
		
		return "";
	}
	
	public String update() {
		
		return "";
	}
	
	/** Initialize all the properties that are required to access database */
	private void initializeDatabaseProperties() {
		String propertyFile = "jdbc.properties";
		try {
			Properties property = new Properties();
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
			
			if (inputStream == null)
				throw new Exception("Property File " + propertyFile + " Cannot be found!!");
			
			property.load(inputStream);
			this.driver = property.getProperty("driver");
			this.dbUrl = property.getProperty("db_url");
			this.userName = property.getProperty("user");
			this.password = property.getProperty("password");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Initialize database connection using properties that are already set using
	 initializeDatabaseProperties method */
	private void initializeConnection() {
		try {
			Class.forName(this.driver);
			this.connection = DriverManager.getConnection(this.dbUrl, this.userName, this.password);
			this.statement = this.connection.createStatement();
		} catch(Exception e) {
			System.out.println("----- Error in JDBC Connection -----");
			e.printStackTrace();
		}
	}
}
