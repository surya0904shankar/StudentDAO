package com.bhaiti.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bhaiti.beans.StudentRegistrationReply;

public class StudentDAO {

	StudentRegistrationReply student = new StudentRegistrationReply();

	void addNewstudent(StudentRegistrationReply student) {

		String studentName = student.getName();
		int studentAge = student.getAge();
		String regNo = student.getRegistrationNumber();
		Connection con = StudentDAO.getConnection();
		if (con == null) {
			System.out.println("Connection is null");
			return;
		}
		PreparedStatement ps = null;

		String sql = "insert into student values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, studentName);
			ps.setInt(2, studentAge);
			ps.setString(3, regNo);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void updatestudent(StudentRegistrationReply student) {
		String studentName = student.getName();
		int age = student.getAge();
		String regNo = student.getRegistrationNumber();
		Connection con = StudentDAO.getConnection();
		PreparedStatement ps = null;

		String sql = "Update student set name= ? , age=? where registrationNumber=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, studentName);
			ps.setInt(2, age);
			ps.setString(3, regNo);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void removestudent(String regNo) {
		String registrationNumber = regNo;
		Connection con = StudentDAO.getConnection();
		PreparedStatement ps = null;

		String sql = "delete from student where registrationNumber=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, registrationNumber);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	StudentRegistrationReply findstudent(String registrationNumber) throws SQLException {
		student = new StudentRegistrationReply();
		Connection con = StudentDAO.getConnection();
		PreparedStatement ps = null;
		String name = "";
		String regNo = "";
		int age = 0;
		String sql = "select * from student where registrationNumber =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, registrationNumber);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			if (rs == null)
				return null;
			while (rs.next()) {
				name = rs.getString(1);
				age = rs.getInt(2);
				regNo = rs.getString(3);
				student.setName(name);
				student.setAge(age);
				student.setRegistrationNumber(regNo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return student;

	}

	private static Connection getConnection() {
		// DataSource
		String MYSQL_DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost:3306/student";

		Connection con = null;
		String strUserName = "root";
		String strPassword = "root";
		try {
			java.util.Properties p = new java.util.Properties();
			p.put("user", strUserName);
			p.put("password", strPassword);
			String driverName = MYSQL_DRIVERNAME;
			Class.forName(driverName);
			String url = MYSQL_CONNECTION_URL;
			con = DriverManager.getConnection(url, p);

		} catch (SQLException err) {
			System.out.println("Sql exception err." + err.getMessage());
		} catch (Exception err) {
			System.out.println("Exception:  " + err.getMessage());
		}
		return con;

	}

}
