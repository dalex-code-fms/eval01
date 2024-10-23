package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnection {
	private static Connection connection = null;
	private static String driver;
	private static String url;
	private static String login;
	private static String pwd;
	
	private static final Logger logger = Logger.getLogger(DBConnection.class.getName());
	
	private DBConnection() {
		
		try {
			getConfigFile();
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, pwd);
		}catch (ClassNotFoundException e) {
			logger.severe("Problem connecting to jdbc driver : " + e.getMessage());
		}catch (SQLException e) {
			logger.severe("Error connecting to the database : " + e.getMessage());
		}catch (Exception e) {
			logger.severe("Unexpected error : " + e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		if (connection == null) new DBConnection();
		return connection;
	}
	
	public static void getConfigFile() {
		Properties prop = new Properties();
		
		try (FileInputStream fis = new FileInputStream("files/conf.properties")){
			prop.load(fis);
			driver = prop.getProperty("db.driver");
			url = prop.getProperty("db.url");
			login = prop.getProperty("db.login");
			pwd = prop.getProperty("db.pwd");
		}catch (FileNotFoundException e) {
			logger.severe("Config file not found " + e.getMessage());
		}catch (IOException e) {
			logger.severe("Error reading config file " + e.getMessage());
		}	
	}
}
