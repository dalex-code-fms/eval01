package fr.fms;

import java.util.Scanner;

import fr.fms.business.IBusinessImpl;

public class Shop {

	private static Scanner sc = new Scanner(System.in);
	private static IBusinessImpl ibus = new IBusinessImpl();

	public static void main(String[] args) {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.printf("|%59s%s%-59s|%n", "", "Welcome to FMS Course Shop", "");
		displayCourses();

	}

	public static void displayCourses() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n", "ID", "NAME", "DESCRIPTION",
				"DURATION", "FORMAT", "PRICE", "CATEGORY");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		ibus.readAllCourses()
				.forEach(course -> System.out.printf("%-5s | %-35s | %-50s | %-8s | %-10s | %-10s | %-8s |%n",
						course.getId(), course.getName(), course.getDescription(), course.getDuration(),
						course.getFormat(), course.getPrice(), course.getIdCategory()));
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
	}

}
