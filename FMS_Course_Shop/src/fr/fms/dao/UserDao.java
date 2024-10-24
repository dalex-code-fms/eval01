package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.User;

public class UserDao implements Dao<User> {

	@Override
	public boolean create(User obj) {
		String strSQL = "INSERT INTO T_Users ( login , pwd ) VALUES ( ?, ? );";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPwd());

			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			logger.severe("SQL Problem when trying to create a new user : " + e.getMessage());
		}
		return false;
	}

	@Override
	public User read(int id) {
		String strSQL = "SELECT * FROM T_Users WHERE id=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new User(rs.getInt("id"), rs.getString("login"), rs.getString("pwd"));
				}
			}
		} catch (SQLException e) {
			logger.severe("SQL problem trying to read a user : " + e.getMessage());
		}

		return null;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
