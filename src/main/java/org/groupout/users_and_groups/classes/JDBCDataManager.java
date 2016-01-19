package org.groupout.users_and_groups.classes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.groupout.users_and_groups.utils.JDBCQueryHelper;

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
		this.columnValueMap = new HashMap<String, T>();
		this.initializeDatabaseProperties();
		this.initializeConnection();
	}
	
	public void setValue(String column, T value) {
		this.columnValueMap.put(column, value);
	}
	
	public T getValue(String column) {
		return this.columnValueMap.get(column);
	}
	
	/**
	 * Inserts the values set in the map and returns a unique id associated with this record
	 * if the insert was successful
	 * @return true if the record insert was successful
	 */
	public boolean insert() {
		try {
			String query = JDBCQueryHelper.getInsertQueryFromMap(this.tableName, this.columnValueMap);
			this.statement.executeUpdate(query);
			return true;
		} catch(Exception e) {
			System.out.println("Error inserting record into the database");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update() {
		
		return true;
	}
	
	/**
	 * Closes the connection maintained by this data manager
	 * @return true if the connection is closed successfully
	 */
	public boolean closeConnection() {
		try {
			if (this.connection != null) {
				this.connection.close();
				return true;
			}
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
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