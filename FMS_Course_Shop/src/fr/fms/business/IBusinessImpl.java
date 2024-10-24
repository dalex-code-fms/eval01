package fr.fms.business;

import java.util.ArrayList;

import fr.fms.dao.CourseDao;
import fr.fms.entities.Category;
import fr.fms.entities.Courses;

public class IBusinessImpl implements IBusiness {

	private CourseDao courseDao = new CourseDao();

	@Override
	public void addToCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Courses> getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createOrder(int idUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Courses readOneCourse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Category> readCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Courses> readAllCourses() {
		return courseDao.readAll();
	}

}
