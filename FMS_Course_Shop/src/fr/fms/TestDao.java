package fr.fms;

import fr.fms.dao.CourseDao;
import fr.fms.entities.Courses;

public class TestDao {

	public static void main(String[] args) {
		
		CourseDao courseDao = new CourseDao();
		
		if (courseDao.create(new Courses("Introduction to Machine Learning", "fundamental concepts of machine learning", 40, "remote", 199.99, 4))) System.out.println("added to db");
		
		System.out.println(courseDao.readAll());
	}

}
