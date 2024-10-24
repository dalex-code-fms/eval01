package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.OrderItem;

public class OrderItemDao implements Dao<OrderItem> {

	@Override
	public boolean create(OrderItem obj) {
		String strSQL = "INSERT INTO T_Order_Items ( idCourse, price, idOrder ) VALUES ( ?, ?, ? );";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, obj.getId());
			ps.setDouble(2, obj.getPrice());
			ps.setInt(3, obj.getIdOrder());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to create a new orderItem : " + e.getMessage());
		}

		return false;
	}

	@Override
	public OrderItem read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
