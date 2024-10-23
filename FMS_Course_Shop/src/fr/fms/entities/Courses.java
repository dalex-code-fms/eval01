package fr.fms.entities;

public class Courses {
	private int id;
	private String name;
	private String description;
	private int duration;
	private String format;
	private double price;
	private int idCategory;
	
	public Courses(String name, String description, int duration, String format, double price, int idCategory) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.format = format;
		this.price = price;
		this.idCategory= idCategory;
	}
	
	@Override
	public String toString() {
		return String.format("Course : %d %s, %s, %d, %s, %f, %d", id, name, description, duration, format, price, idCategory);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
}
