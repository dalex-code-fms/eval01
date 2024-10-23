package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Courses;

public class CourseDao implements Dao<Courses> {

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

	@Override
	public Courses read(int id) {
		String strSQL = "SELECT * FROM T_Courses WHERE id=?;";

		try (PreparedStatement ps = connection.prepareStatement(strSQL)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					Courses course = new Courses(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
							rs.getInt("duration"), rs.getString("format"), rs.getDouble("price"),
							rs.getInt("idCategory"));

					return course;
				}
			}
		} catch (SQLException e) {
			logger.severe("SQL problem when trying to read a course : " + e.getMessage());
		}
		return null;
	}

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