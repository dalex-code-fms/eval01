package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Category;

public class CategoryDao implements Dao<Category> {

	@Override
	public boolean create(Category obj) {
		String strSQL = "INSERT INTO T_Categories ( name ) VALUES (?);";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getName());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to create a new category : " + e.getMessage());
		}
		return false;
	}

	@Override
	public Category read(int id) {
		String strSQL = "SELECT * FROM T_Categories WHERE id=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					return new Category(rs.getInt("id"), rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to read a category : " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Category obj) {
		String strSQL = "UPDATE T_Categories SET name=? WHERE id=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getId());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to update a category : " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		/*
		 * String strSQL = "DELETE FROM T_Categories WHERE id=?;";
		 * 
		 * try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
		 * ps.setInt(1, obj.getId());
		 * 
		 * if (ps.executeUpdate() > 0) return true; } catch (SQLException e) {
		 * logger.severe("SQL problem when trying to delete a category : " +
		 * e.getMessage()); }
		 */

		// have to verify if there isn't associated course before delete a category !!!
		return false;
	}

	@Override
	public ArrayList<Category> readAll() {
		ArrayList<Category> category = new ArrayList<>();
		String strSQL = "SELECT * FROM T_Categories;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					category.add(new Category(rs.getInt("id"), rs.getString("name")));
				}
				return category;
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to read all courses : " + e.getMessage());
		}
		return null;
	}
}
