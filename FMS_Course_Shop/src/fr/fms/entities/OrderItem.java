package fr.fms.entities;

public class OrderItem {
	private int id;
	private int idCourse;
	private int idOrder;
	private double price;
	
	public OrderItem(int idCourse, int idOrder, double price) {
		this.idCourse = idCourse;
		this.idOrder = idOrder;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
