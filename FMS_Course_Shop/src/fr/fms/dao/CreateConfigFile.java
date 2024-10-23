package fr.fms.dao;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class CreateConfigFile {
	
	private static final Logger logger = Logger.getLogger(CreateConfigFile.class.getName());

	public static void main(String[] args) {
		
		try (BufferedOutputStream buf = new BufferedOutputStream(new FileOutputStream("files/conf.properties"))){
			Properties prop = new Properties();
			prop.setProperty("db.driver", "org.mariadb.jdbc.Driver");
			prop.setProperty("db.url", "jdbc:mariadb://localhost:3306/FmsCourseShop");
			prop.setProperty("db.login", "root");
			prop.setProperty("db.pwd", "fms2024");
			prop.store(buf, "Store properties on conf.properties file.");
		} catch (IOException e) {
			logger.severe("IO Problem config file : " + e.getMessage());
		}
	}				
}
