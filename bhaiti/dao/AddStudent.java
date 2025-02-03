package com.bhaiti.dao;

import com.bhaiti.beans.StudentRegistrationReply;

public class AddStudent {
	private StudentRegistrationReply student;

	public AddStudent(StudentRegistrationReply student) {
		this.student = student;
	}

	public void addStud() {
		StudentDAO record = new StudentDAO();
		try {
			record.addNewstudent(student);
			System.out.println("inserted successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
