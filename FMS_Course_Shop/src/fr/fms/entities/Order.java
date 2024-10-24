package fr.fms.entities;

import java.util.Date;

public class Order {
	private int id;
	private double totalPrice;
	private Date date;
	private int idCustomer;

	public Order(int id, double totalPrice, Date date, int idCustomer) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.date = date;
		this.idCustomer = idCustomer;
	}

	public Order(double totalPrice, Date date, int idCustomer) {
		this.totalPrice = totalPrice;
		this.date = date;
		this.idCustomer = idCustomer;
	}

	public Order(double totalPrice, int idCustomer) {
		this.totalPrice = totalPrice;
		this.idCustomer = idCustomer;
	}

	@Override
	public String toString() {
		return String.format("Order: [ id='%d', totalPrice='%.2f', date='%s', idCustomer='%d' ]%n", id, totalPrice,
				date, idCustomer);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
}
