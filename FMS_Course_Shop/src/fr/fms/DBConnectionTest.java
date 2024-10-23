package fr.fms;

import java.sql.Connection;

import fr.fms.dao.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		Connection connection = DBConnection.getConnection();
		
		if (connection != null) {
			System.out.println("Connection etablished successfully !");
		}

	}

}
