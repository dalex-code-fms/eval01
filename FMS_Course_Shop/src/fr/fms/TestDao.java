package fr.fms;

import fr.fms.dao.CourseDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Customer;
import fr.fms.entities.User;

public class TestDao {

	public static void main(String[] args) {

		CourseDao courseDao = new CourseDao();
		UserDao userDao = new UserDao();
		CustomerDao csDao = new CustomerDao();

		// userDao.create(new User("david", "fms123"));

		User user = userDao.read(4);

		System.out.println(user);
		// System.out.println(courseDao.readAll());

		user.setLogin("sabrina");
		userDao.update(user);
		user = userDao.read(4);
		System.out.println(user);

		// userDao.delete(user);

		System.out.println(userDao.readAll());
		System.out.println(courseDao.readAll());

		// csDao.create(new Customer("david", "rodrigues", "david@fms.fr", "dax",
		// "0655413289", 1));

		Customer customer = csDao.read(1);

		System.out.println(customer);

		customer.setAddress("Bayonne");
		csDao.update(customer);

	}

}
