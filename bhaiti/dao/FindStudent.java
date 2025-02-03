package com.bhaiti.dao;

import java.sql.SQLException;
import java.util.Scanner;

import com.bhaiti.beans.StudentRegistrationReply;

public class FindStudent {
	public static void main(String[] args) throws SQLException {
		StudentRegistrationReply student = new StudentRegistrationReply();
		StudentDAO record = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Registration number");
		String registerNumber = sc.nextLine();
		System.out.println(registerNumber);

		student = record.findstudent(registerNumber);
		if (student == null)
			System.out.println("student not found");
		else {
			System.out.print(student.getName());
			System.out.print("\t" + student.getAge());
			System.out.println("\t" + student.getRegistrationNumber());

		}
	}
}
