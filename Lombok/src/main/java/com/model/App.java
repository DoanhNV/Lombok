package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.extern.log4j.Log4j;

@Log4j
class Service {

	public static void displayComputer() {
		Computer computer = new Computer("keyboard1", "asus", "dell");
		Computer computer2 = new Computer("keyboard1", "asus", "dell");
		System.out.println(computer.getKeyBoard() + " - " + computer.getScreen() + " - " + computer.getSourceCase());
		System.out.println(computer);
		System.out.println(computer.equals(computer2));
	}

	public static void displayStudent(@NonNull Student student) {
		System.out.println(student);
	}

	public static void displayVarAndVal() {
		System.out.println(new Employee());
	}

	public static void displayCleanUp() throws FileNotFoundException {
		String filePath = "C:/Users/admin/workspace/Lombok/pom.xml";
		try {
			@Cleanup
			InputStream inputStream = new FileInputStream(new File(filePath));
			int a = 0;
			while ((a = (inputStream.read())) != -1) {
				System.out.println((char) a);
			}
			@Cleanup
			OutputStream outputStream = new FileOutputStream("C:/Users/admin/Desktop/temparature.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void displayValue() {
		Tree tree = new Tree("Apple", "green", 20);
		/* tree.set */
		System.out.println(tree);
	}

	public static void displayBuilder() {
		User user = User.builder().userName("Doanh Ngô Văn").password("123456").computer(new Computer()).build();
		user.buildComputer().keyboard("asus").sourceCase("dell").build();
		System.out.println(user);
	}

	public static void testGetterLazy() {
		Cloud cloud = Cloud.builder().color("red").build();
		StringBuilder shape = cloud.getShape();
		shape.append("triangle");
		System.out.println(shape);
	}

	public static void testLog() {
		log.error("Error in here");
		log.info("this is error");
		log.debug("debug");
	}

}

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		// Service.displayComputer();
		// Student stuent = null;
		// Service.displayStudent(stuent);
		// Service.displayEmplyee();
		// Service.displayCleanUp();
		// Service.displayValue();
		// Service.displayBuilder();
		// Service.testGetterLazy();
		Service.testLog();
	}
}
