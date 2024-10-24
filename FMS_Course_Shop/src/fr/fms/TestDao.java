package fr.fms;

import fr.fms.dao.CourseDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.User;

public class TestDao {

	public static void main(String[] args) {

		CourseDao courseDao = new CourseDao();
		UserDao userDao = new UserDao();

		userDao.create(new User("david", "fms123"));
	}

}
