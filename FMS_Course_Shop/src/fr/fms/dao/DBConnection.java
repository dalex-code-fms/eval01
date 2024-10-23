package fr.fms.dao;

import java.sql.Connection;
import java.util.logging.Logger;

public class DBConnection {
	private static Connection connection = null;
	private static String driver;
	private static String url;
	private static String login;
	private static String password;
	
	private static final Logger logger = Logger.getLogger(DBConnection.class.getName());
	
	private DBConnection() {
		
		
	}
}
