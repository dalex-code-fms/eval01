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
		String strSQL = "UPDATE T_Users SET login = ?, pwd = ? WHERE id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPwd());
			ps.setInt(3, obj.getId());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to update a user : " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(User obj) {
		String strSQL = "DELETE FROM T_Users WHERE id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, obj.getId());

			if (ps.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to delete a user : " + e.getMessage());
		}
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<>();
		String strSQL = "SELECT * FROM T_Users;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					users.add(new User(rs.getInt("id"), rs.getString("login"), rs.getString("pwd")));
				}
				return users;
			}
		} catch (SQLException e) {
			logger.severe("SQL Problem when trying to read all users : " + e.getMessage());
		}
		return null;
	}

}
