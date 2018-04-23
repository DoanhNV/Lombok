package com.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import lombok.val;
import lombok.experimental.var;

@Data
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
class Computer {
	private String keyBoard;
	private String screen;
	private String sourceCase;

}

@ToString
@EqualsAndHashCode
class Student {

	@Setter
	@NonNull
	private String studentName;
	private @Getter @Setter int age;
}

class Employee {
	private int age = 1;
	{
		val number = age;
		var number2 = age;
		number2 = 2;
		System.out.println("Employee age: " + number);
		System.out.println("Employee age: " + number2);
	}
}

@Value
class Tree {
	private String name;
	private String color;
	private int numberOfBranch;
}

@Builder
@ToString
class User {
	private String userName;
	private String password;
	public Computer computer;
	
	@Builder(builderMethodName = "buildComputer")
	public void changeEmployee(String keyboard, String sourceCase) {
		computer.setKeyBoard(keyboard);
		computer.setSourceCase(sourceCase);
	}
}

@Builder
class Cloud {
	private final @Getter(lazy = true) StringBuilder shape = new StringBuilder("square");
	private String color;
	
}