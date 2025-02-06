package com.bhaiti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhaiti.beans.*;
import com.bhaiti.dao.StudentDAO;

@Controller
public class StudentRegistrationController {

	@RequestMapping(method = RequestMethod.POST, value = "/register/student")

	@ResponseBody
	public Student registerStudent(@RequestBody Student student) {
		StudentDAO studentDAO = new StudentDAO();
		System.out.println("In registerStudent");
		// Student student1 = new Student();
		StudentRegistration.getInstance().add(student);
		// We are setting the below value just to reply a message back to the caller
		student.setName(student.getName());
		student.setAge(student.getAge());
		student.setRegistrationNumber(student.getRegistrationNumber());
		studentDAO.addNewstudent(student);

		System.out.println("recorded");

		return student;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/modify/student")
	public void modifyStudent(@RequestBody Student student) {
		StudentDAO studentRecord = new StudentDAO();
		studentRecord.updatestudent(student);
		System.out.println("updated successfully");

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/remove/student")
	public void removeStudent(@RequestBody Student student) {
		StudentDAO studentRecord = new StudentDAO();
		studentRecord.removestudent(student.getRegistrationNumber());
		System.out.println("deleted successfully");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getall/student")
	public void getAllStudent() {
		StudentDAO studentRecord = new StudentDAO();
		Student student = new Student();

		studentRecord.fetchall();
		System.out.println("displayed successfully");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/student")
	public void findStudentbyId(@RequestBody String registrationNumber) {
		StudentDAO studentRecord = new StudentDAO();
		Student student = new Student();

		studentRecord.findstudentbyRegistrationNumber(registrationNumber);
		System.out.println("displayed successfully");

	}

}
