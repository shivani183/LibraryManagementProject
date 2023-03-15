package krishna.dao;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import krishna.dto.Student;
import krishna.util.JdbcUtil;

//Persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String addStudent(Student student) {

		String sqlInsertQuery = "insert into Student(`sid`,`sname`,`scourse`,`sphone`)values(?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				pstmt.setInt(1, student.getSid());
				pstmt.setString(2, student.getSname());
				pstmt.setString(3, student.getScourse());
				pstmt.setLong(4, student.getSphone());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		String sqlSelectQuery = "select sid,sname,scourse,sphone from Student where sid = ?";
		Student student = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null)
				pstmt.setInt(1, sid);

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					student = new Student();

					// copy resultSet data to student object
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setScourse(resultSet.getString(3));
					student.setSphone(resultSet.getLong(4));

					return student;
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return student;
	}


	@Override
	public String deleteStudent(Integer sid) {
		String sqlDeleteQuery = "delete from Student where sid = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);

			if (pstmt != null) {

				pstmt.setInt(1, sid);

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				} else {
					return "not found";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";

	}

	@Override
	public String updateStudent(Student student) {
		String sqlUpdateQuery = "update Student set sname=?,scourse=?,sphone=? where sid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, student.getSname());
				pstmt.setString(2, student.getScourse());
				pstmt.setLong(3, student.getSphone());
				pstmt.setInt(4, student.getSid());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

}
