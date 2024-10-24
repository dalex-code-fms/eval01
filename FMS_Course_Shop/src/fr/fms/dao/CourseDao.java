package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Courses;

/**
 * Data Access Object (DAO) for managing Course entities in the database.
 */

public class CourseDao implements Dao<Courses> {

	/**
	 * Creates a new course in the database.
	 * 
	 * @param obj The course object.
	 * @return true if the course was created and false if not.
	 */

	@Override
	public boolean create(Courses obj) {
		String strSQL = "INSERT INTO T_Courses ( name, description, duration, format, price, idCategory ) VALUES (?, ?, ?, ?, ?, ?);";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDuration());
			ps.setString(4, obj.getFormat());
			ps.setDouble(5, obj.getPrice());
			ps.setInt(6, obj.getIdCategory());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to create a new course : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Reads a course from the database based on the its ID.
	 * 
	 * @param id The ID of the course.
	 * @return The course obj if found and null if not.
	 */

	@Override
	public Courses read(int id) {
		String strSQL = "SELECT * FROM T_Courses WHERE id=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					return new Courses(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
							rs.getInt("duration"), rs.getString("format"), rs.getDouble("price"),
							rs.getInt("idCategory"));
				}
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to read a course : " + e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a course in the database.
	 * 
	 * @param obj The course object with updated values.
	 * @return true if the course was been updated, false if not.
	 */

	@Override
	public boolean update(Courses obj) {
		String strSQL = "UPDATE T_Courses SET name=?, description=?, duration=?, format=?, price=?, idCategory=? WHERE id=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDuration());
			ps.setString(4, obj.getFormat());
			ps.setDouble(5, obj.getPrice());
			ps.setInt(6, obj.getIdCategory());
			ps.setInt(7, obj.getId());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to update a course : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Deletes a course from the database.
	 * 
	 * @param obj The course object to delete.
	 * @return true if the course was deleted, false if not.
	 */

	@Override
	public boolean delete(Courses obj) {
		String strSQL = "DELETE FROM T_Courses WHERE id=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, obj.getId());

			if (ps.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to delete a course : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Reads all courses from the database.
	 * 
	 * @return a list of all courses.
	 */

	@Override
	public ArrayList<Courses> readAll() {
		ArrayList<Courses> courses = new ArrayList<>();
		String strSQL = "SELECT * FROM T_Courses;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Courses course = new Courses(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
							rs.getInt("duration"), rs.getString("format"), rs.getDouble("price"),
							rs.getInt("idCategory"));
					courses.add(course);
				}
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to read all courses : " + e.getMessage());
		}
		return courses;
	}

}
