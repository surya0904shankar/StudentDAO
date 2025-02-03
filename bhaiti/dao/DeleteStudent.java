package com.bhaiti.dao;

import java.util.Scanner;

public class DeleteStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Student name");
		String registrationNumber = sc.nextLine();
		StudentDAO record = new StudentDAO();
		record.removestudent(registrationNumber);
		System.out.println("Student deleted successfully");
	}
}