package fr.fms.entities;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phone;
	
	public Customer(String firstName, String lastName, String email, String address, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return String.format("Customer : %d, %s, %s, %s, %s, %s%n", id, firstName, lastName, email, address, phone);
	}
}
