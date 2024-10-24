package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Category;
import fr.fms.entities.Courses;

public interface IBusiness {
	public void addToCart();

	public void removeFromCart();

	public ArrayList<Courses> getCart();

	public void displayCoursesByCat();

	public void displayCoursesByformat();

	public void displayCoursesByKeyword();

	public int createOrder(int idUser);

	public Courses readOneCourse();

	public ArrayList<Category> readCategories();
}
