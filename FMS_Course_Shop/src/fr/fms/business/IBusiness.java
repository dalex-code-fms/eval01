package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Category;
import fr.fms.entities.Courses;

public interface IBusiness {
	public void addToCart();

	public void removeFromCart();

	public ArrayList<Courses> getCart();

	public int createOrder(int idUser);

	public ArrayList<Courses> readAllCourses();

	public Courses readOneCourse();

	public ArrayList<Category> readCategories();
}
