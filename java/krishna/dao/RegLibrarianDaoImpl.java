package krishna.dao;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import krishna.dto.RegisterLibrarian;
import krishna.util.JdbcUtil;

//Persistence logic using JDBC API
public class RegLibrarianDaoImpl implements IRegLibrarianDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String registerLibrarian(RegisterLibrarian registerLibrarian) {
		String sqlInsertQuery = "insert into regLibrarian(lname,lusername,lpassword)values (?, ?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				pstmt.setString(1, registerLibrarian.getLname());
				pstmt.setString(2, registerLibrarian.getLusername());
				pstmt.setString(3, registerLibrarian.getLpassword());

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
