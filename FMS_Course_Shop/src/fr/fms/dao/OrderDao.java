package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Order;

public class OrderDao implements Dao<Order> {

	@Override
	public boolean create(Order obj) {
		String strSQL = "INSERT INTO T_Orders ( totalPrice, idCustomer ) VALUES ( ?, ? );";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setDouble(1, obj.getTotalPrice());
			ps.setInt(2, obj.getIdCustomer());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to create a new order : " + e.getMessage());
		}
		return false;
	}

	@Override
	public Order read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Order> readAll() {
		ArrayList<Order> order = new ArrayList<>();
		String strObj = "SELECT * FROM T_Orders;";

		try (PreparedStatement ps = connection.prepareStatement(strObj)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					order.add(new Order(rs.getInt("id"), rs.getDouble("totalPrice"), rs.getDate("dateOrder"),
							rs.getInt("idCustomer")));
			}
			return order;
		} catch (SQLException e) {
			logger.severe("SQLException problem when trying to display all orders : " + e.getMessage());
		}
		return null;
	}

}
