package fr.fms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Courses;

public class Shop {

	private static Scanner sc = new Scanner(System.in);
	private static IBusinessImpl ibus = new IBusinessImpl();

	public static void main(String[] args) {
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("|%60s%s%-60s|%n", "", "WELCOME TO FMS COURSE SHOP", "");

		int choice = 0;

		while (choice != 9) {
			displayCourses();
			displayMenu();
			choice = verifyUserInput();
			switch (choice) {
			case 1:
				addCourseToCart();
				break;
			case 2:
				displayCart();
				break;
			case 3:
				displayCourses();
				displaySortedOrderMenu();
				break;
			}
		}

	}

	public static void displayMenu() {
		displayTextLines();
		System.out.printf("|%47s%s%-46s|%n", "", "CHOOSE AS ACTION BY ENTERING THE CORRESPONDING NUMBER", "");
		displayTextLines();
		System.out.printf("|%-7s%s%7s|%-7s%s%7s|%-7s%s%7s|%-7s%s%7s|%-7s%s%8s|%n", "", "1 - ADD TO CART", "", "",
				"2 - DISPLAY CART", "", "", "3 - DISPLAY COURSES BY:", "", "", "4 - LOGIN", "", "", "9 - EXIT", "");
		displayTextLines();
	}

	public static void displayCourses() {
		displayTextLines();
		System.out.printf("| %-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n", "ID", "NAME", "DESCRIPTION",
				"DURATION", "FORMAT", "PRICE", "CATEGORY");
		displayTextLines();
		ibus.readAllCourses()
				.forEach(course -> System.out.printf("| %-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n",
						course.getId(), course.getName(), course.getDescription(), course.getDuration(),
						course.getFormat(), course.getPrice(), course.getIdCategory()));
		displayTextLines();
	}

	public static void displayCart() {
		displayTextLines();
		System.out.println("| Cart |");
		displayTextLines();
		ArrayList<Courses> cart = ibus.getCart();
		cart.forEach(course -> System.out.printf("| %-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n",
				course.getId(), course.getName(), course.getDescription(), course.getDuration(), course.getFormat(),
				course.getPrice(), course.getIdCategory()));
	}

	public static void displaySortedOrderMenu() {

		int choice = 0;
		while (choice != 5) {
			displayTextLines();
			System.out.printf("|%47s%s%-46s|%n", "", "CHOOSE AS ACTION BY ENTERING THE CORRESPONDING NUMBER", "");
			displayTextLines();
			System.out.printf("|%-9s%s%8s|%-9s%s%8s|%-9s%s%8s|%-9s%s%9s|%-9s%s%9s|%n", "", "1 - CATEGORIES", "", "",
					"2 - KEYWORD", "", "", "3 - FORMAT", "", "", "4 - PRICE", "", "", "5 - GO BACK", "");
			displayTextLines();
			choice = verifyUserInput();
			switch (choice) {
			case 1:
				displaySortedCourses(Comparator.comparing(Courses::getIdCategory));
				break;
			case 2:
				displayCoursesByKeyword();
				break;
			case 3:
				displaySortedCourses(Comparator.comparing(Courses::getFormat));
				break;
			case 4:
				displaySortedCourses(Comparator.comparing(Courses::getPrice));
				break;
			}
		}

	}

	public static void addCourseToCart() {
		System.out.println("Choose a course by enter the corresponding number");
		int id = verifyUserInput();
		Courses course = ibus.readOneCourse(id);

		if (course != null) {
			ibus.addToCart(course);
			System.err.printf("Added successfully the course: '%s' to the cart.%n", course.getName());
		} else
			System.out.println("The course id choosen is not valid !");
	}

	public static int verifyUserInput() {
		while (!sc.hasNextInt()) {
			System.out.println("You have to enter a valid number !");
			sc.next();
		}
		return sc.nextInt();
	}

	public static void displaySortedCourses(Comparator<Courses> comparator) {
		ArrayList<Courses> courses = ibus.readAllCourses();
		courses.sort(comparator);
		displayTextLines();
		System.out.printf("| %-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n", "ID", "NAME", "DESCRIPTION",
				"DURATION", "FORMAT", "PRICE", "CATEGORY");
		displayTextLines();
		courses.forEach(course -> System.out.printf("| %-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n",
				course.getId(), course.getName(), course.getDescription(), course.getDuration(), course.getFormat(),
				course.getPrice(), course.getIdCategory()));
		displayTextLines();
	}

	public static void displayCoursesByKeyword() {
		System.out.print("Enter the keyword : ");
		String userInputScanner = sc.next().toLowerCase();
		ArrayList<Courses> courses = ibus.readAllCourses();

		boolean found = false;

		displayTextLines();
		System.out.printf("| %-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n", "ID", "NAME", "DESCRIPTION",
				"DURATION", "FORMAT", "PRICE", "CATEGORY");
		displayTextLines();
		for (Courses course : courses) {
			if (course.getName().toLowerCase().contains(userInputScanner)
					|| course.getDescription().toLowerCase().contains(userInputScanner)) {
				System.out.printf("| %-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n", course.getId(),
						course.getName(), course.getDescription(), course.getDuration(), course.getFormat(),
						course.getPrice(), course.getIdCategory());
				found = true;
			}
		}

		if (!found)
			System.out.printf("|%-64s%s%65s|%n", "", "NO COURSES FOUND.", "");
		displayTextLines();
	}

	public static void displayTextLines() {
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");
	}
}
