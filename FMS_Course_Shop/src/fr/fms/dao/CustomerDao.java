package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Customer;

/**
 * Data Access Object (DAO) for managing Customer entities in the database.
 */

public class CustomerDao implements Dao<Customer> {

	/**
	 * Creates a nex customer in the database.
	 * 
	 * @param obj The customer object.
	 * @return true if the customer has been created, false if not
	 */

	@Override
	public boolean create(Customer obj) {
		String strSQL = "INSERT INTO T_Customers ( firstName, lastName, email, address, phone, idUser ) VALUES (?, ?, ?, ?, ?, ?);";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getAddress());
			ps.setString(5, obj.getPhone());
			ps.setInt(6, obj.getIdUser());

			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			logger.severe("SQL problem trying to create a customer : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Reads a customer from the database based on its ID.
	 * 
	 * @param id The ID of the customer
	 * @return The customer object if found, null if not.
	 */

	@Override
	public Customer read(int id) {
		String strSQL = "SELECT * FROM T_Customers WHERE id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return new Customer(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
							rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getInt("idUser"));
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to read a customer : " + e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database.
	 * 
	 * @param obj The customer object with updated values.
	 * @return true if the customer has been updated, false if not.
	 */

	@Override
	public boolean update(Customer obj) {
		String strSQL = "UPDATE T_Customers SET firstName=?, lastName=?, email=?, address=?, phone=?, idUser=? WHERE id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getAddress());
			ps.setString(5, obj.getPhone());
			ps.setInt(6, obj.getIdUser());
			ps.setInt(7, obj.getId());

			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			logger.severe("SQL problem when trying to update a customer : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Deletes a customer from the database.
	 * 
	 * @param obj The customer obj.
	 * @return true if the customer has been deleted, false if not.
	 */

	@Override
	public boolean delete(Customer obj) {
		String strSQL = "DELETE FROM T_Customers WHERE id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, obj.getId());

			if (ps.executeUpdate() > 0)
				return true;

		} catch (SQLException e) {
			logger.severe("SQL problem when trying to delete a customer : " + e.getMessage());
		}

		return false;
	}

	/**
	 * Reads all customers in the database.
	 * 
	 * @return A list of all customers.
	 */

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<>();

		String strSQL = "SELECT * FROM T_Customers;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					customers.add(new Customer(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
							rs.getString("email"), rs.getString("address"), rs.getString("phone"),
							rs.getInt("idUser")));
				}
				return customers;
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying do display all customers : " + e.getMessage());
		}
		return null;
	}

	/**
	 * Find customer in the database by is email.
	 * 
	 * @param email
	 * @return The customer object if found in the database.
	 */

	public Customer findCustomerByEmail(String email) {
		String strSQL = "SELECT * FROM T_Customers WHERE email=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return new Customer(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
							rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getInt("idUser"));
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to find customer by email : " + e.getMessage());
		}
		return null;
	}

}
