package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import krishna.util.JdbcUtil;

@WebServlet("/LoginAdminController")
public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		String sqlInsertQuery = "select ausername from adminDetail where ausername=? and apassword=?";
		String u = request.getParameter("ausername");
		String p = request.getParameter("apassword");
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if(pstmt!=null) {
				pstmt.setString(1, u);
				pstmt.setString(2, p);
			}
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("regLibrarian.html");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		
		
		
	}
}
