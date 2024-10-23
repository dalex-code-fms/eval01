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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
