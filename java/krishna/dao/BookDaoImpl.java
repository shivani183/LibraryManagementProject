package krishna.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import krishna.dto.Book;
import krishna.util.JdbcUtil;

//Persistence logic using JDBC API
public class BookDaoImpl implements IBookDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String addBook(Book book) {

		String sqlInsertQuery = "insert into Book(`bid`,`bname`,`bauthor`,`bsubject`,`quantity`)values(?,?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				pstmt.setString(1, book.getBid());
				pstmt.setString(2, book.getBname());
				pstmt.setString(3, book.getBauthor());
				pstmt.setString(4, book.getBsubject());
				pstmt.setInt(5, book.getQuantity());

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
	public ResultSet searchBookBySub(String bsubject) {
		String sqlSelectQuery = "select bid,bname,bauthor,bsubject,quantity from Book where bsubject = ?";
		Book book = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null)
				pstmt.setString(1, bsubject);
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
				System.out.println(resultSet);
				return resultSet;
			}
			
		} catch (SQLException | IOException e) {
		}
		return resultSet;
	}
	
	@Override
	public Book searchBookByAuthor(String bauthor) {
		String sqlSelectQuery = "select bid,bname,bauthor,bsubject,quantity from Book where bauthor = ?";
		Book book = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null)
				pstmt.setString(1, bauthor);
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {

				if (resultSet.next()) {
					book = new Book();
					book.setBid(resultSet.getString(1));
					book.setBname(resultSet.getString(2));
					book.setBauthor(resultSet.getString(3));
					book.setBsubject(resultSet.getString(4));
					book.setQuantity(resultSet.getInt(5));
					return book;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public Book searchBookByTitle(String bname) {
		String sqlSelectQuery = "select bid,bname,bauthor,bsubject,quantity from Book where bname = ?";
		Book book = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null)
				pstmt.setString(1, bname);
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {

				if (resultSet.next()) {
					book = new Book();
					book.setBid(resultSet.getString(1));
					book.setBname(resultSet.getString(2));
					book.setBauthor(resultSet.getString(3));
					book.setBsubject(resultSet.getString(4));
					book.setQuantity(resultSet.getInt(5));
					return book;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	


	@Override
	public String deleteBook(String bid) {
		String sqlDeleteQuery = "delete from Book where bid = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);

			if (pstmt != null) {

				pstmt.setString(1, bid);

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
	public String updateBook(Book book) {
		String sqlUpdateQuery = "update Book set bname=?,bauthor=?,bsubject=?,quantity=? where bid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, book.getBname());
				pstmt.setString(2, book.getBauthor());
				pstmt.setString(3, book.getBsubject());
				pstmt.setString(4, book.getBid());
				pstmt.setInt(5, book.getQuantity());

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
