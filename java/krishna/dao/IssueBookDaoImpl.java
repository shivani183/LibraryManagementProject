package krishna.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import krishna.dto.IssueBook;
import krishna.dto.RegisterLibrarian;
import krishna.util.JdbcUtil;

//Persistence logic using JDBC API
public class IssueBookDaoImpl implements IssueBookDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	ResultSet rs1 = null;
	ResultSet rs = null;

	@Override
	public String addIssueBook(IssueBook issueBook) {

		String sqlQuery1 = "select quantity from Book where bid=?";
		String sqlQuery2 = "insert into IssueBook(`bid`,`sid`,`issueDate`,`dueDate`) values((select bid from Book where bid=?),( select sid from Student where sid=?),?,?)";

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt1 = connection.prepareStatement(sqlQuery1);
			if (pstmt1 != null) {
				pstmt1.setString(1, issueBook.getBid());
			}
			if (pstmt1 != null) {
				rs1 = pstmt1.executeQuery();
				if (rs1 != null) {
					if (rs1.next()) {
						if (rs1.getInt(1) >= 1) {
							Integer i = rs1.getInt(1);

							System.out.println(rs1.getInt(1));
							System.out.println("You can proceed");
							try {
								if (connection != null)
									pstmt = connection.prepareStatement(sqlQuery2);

								if (pstmt != null) {
									pstmt.setString(1, issueBook.getBid());
									pstmt.setInt(2, issueBook.getSid());
									pstmt.setString(3, issueBook.getIssuedate());
									pstmt.setString(4, issueBook.getDuedate());

									int rowAffected = pstmt.executeUpdate();
									if (rowAffected == 1) {
										return "success";
									}
								}
							} catch (SQLException e) {
								return "failure";
							}

						} else {
							System.out.println("No book available wait till new check-in");
							return "failure";
						}
					}
				}
			}
		} catch (SQLException | IOException e) {
			return "failure";
		}
		return "failure";
	}

	@Override
	public ResultSet checkdue(Integer sid) {
		String sqlQuery = "select Student.sid,Student.sname,Book.bid,Book.bname,IssueBook.issuedate, IssueBook.duedate FROM IssueBook\r\n"
				+ "INNER JOIN Book ON IssueBook.bid=Book.bid INNER JOIN Student ON IssueBook.sid=Student.sid where IssueBook.sid=?;";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt2 = connection.prepareStatement(sqlQuery);
				if (pstmt2 != null) {
					pstmt2.setInt(1, sid);
					rs = pstmt2.executeQuery();
					System.out.println(rs);
					return rs;
				}
			}
		} catch (SQLException | IOException e) {

		}
		return rs;
	}

	@Override
	public String returnBook(Integer sid, String bid) {

		String deleteQuery = "delete from IssueBook where sid = ( select sid from Student where sid=?) and bid=(select bid from Book where bid=?);";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt3 = connection.prepareStatement(deleteQuery);
				if (pstmt3 != null) {
					pstmt3.setInt(1, sid);
					pstmt3.setString(2, bid);
					int rowAffected = pstmt3.executeUpdate();
					if (rowAffected == 1) {
						return "success";
					} else {
						return "not found";
					}
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}

}
