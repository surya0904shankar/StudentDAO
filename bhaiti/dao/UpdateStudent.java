package com.bhaiti.dao;

import java.util.Scanner;

import com.bhaiti.beans.StudentRegistrationReply;

public class UpdateStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter student Registration number");
		String registrationNumber = sc.nextLine();
		System.out.println("enter new name");
		String name = sc.nextLine();
		System.out.println("enter new age");
		int age = sc.nextInt();
		StudentRegistrationReply student = new StudentRegistrationReply();
		student.setRegistrationNumber(registrationNumber);
		student.setName(name);
		student.setAge(age);
		StudentDAO studentRecord = new StudentDAO();
		studentRecord.updatestudent(student);
		System.out.println("updated successfully");
	}
}