package fr.fms;

import fr.fms.dao.CourseDao;
import fr.fms.entities.Courses;

public class TestDao {

	public static void main(String[] args) {

		CourseDao courseDao = new CourseDao();

		Courses course = courseDao.read(2);
		course.setDuration(60);
		System.out.println(courseDao.read(2));
		courseDao.update(course);

		System.out.println(courseDao.readAll());
	}

}
