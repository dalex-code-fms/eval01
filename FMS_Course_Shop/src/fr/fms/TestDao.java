package fr.fms;

import fr.fms.dao.CourseDao;
import fr.fms.entities.Courses;

public class TestDao {

	public static void main(String[] args) {
		
		CourseDao courseDao = new CourseDao();
		

		
		System.out.println(courseDao.readAll());
	}

}
