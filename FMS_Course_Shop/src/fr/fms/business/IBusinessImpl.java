package fr.fms.business;

import java.util.ArrayList;

import fr.fms.dao.CourseDao;
import fr.fms.entities.Category;
import fr.fms.entities.Courses;

public class IBusinessImpl implements IBusiness {

	private ArrayList<Courses> cart;
	private CourseDao courseDao = new CourseDao();

	public IBusinessImpl() {
		this.cart = new ArrayList<>();
	}

	@Override
	public void addToCart(Courses course) {
		cart.add(course);
	}

	@Override
	public void removeFromCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Courses> getCart() {
		return cart;
	}

	@Override
	public int createOrder(int idUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Courses readOneCourse(int id) {
		return courseDao.read(id);
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
