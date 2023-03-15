package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import krishna.dao.IssueBookDao;
import krishna.dao.IssueBookDaoImpl;
import krishna.dao.StudentDaoImpl;
import krishna.dto.IssueBook;
import krishna.dto.RegisterLibrarian;
import krishna.dto.Student;
import krishna.service.IRegLibrarianService;
import krishna.service.IssueBookService;
import krishna.servicefactory.issueBookServiceFactory;
import krishna.servicefactory.regLibrarianServiceFactory;

@WebServlet("/issueBookController/*")
public class IssueBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IssueBookService bookService = issueBookServiceFactory.getIssueBookService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("issueBook")) {

			String sid = request.getParameter("sid");
			String bid = request.getParameter("bid");
			String issuedate = request.getParameter("issuedate");
			String duedate = request.getParameter("duedate");

			IssueBook issueBook = new IssueBook();

			issueBook.setBid(bid);
			issueBook.setSid(Integer.parseInt(sid));
			issueBook.setIssuedate(issuedate);
			issueBook.setDuedate(duedate);

			String status = bookService.addIssueBook(issueBook);
			RequestDispatcher rd = null;
			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../insertIssueBook.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../insertIssueBook.jsp");
				rd.forward(request, response);
			}

		}
		if (request.getRequestURI().endsWith("checkDue")) {
			Integer sid = Integer.parseInt(request.getParameter("sid"));
			StudentDaoImpl studentImpl = new StudentDaoImpl();
			Student student = null;
			ResultSet rs = null;
			String status = "fail";
			student = studentImpl.searchStudent(sid);
			IssueBookDaoImpl issuebookImpl = new IssueBookDaoImpl();
			if (student != null) {
				rs = issuebookImpl.checkdue(sid);
				if (rs != null) {
					status = "success";
					HttpSession session = request.getSession();
					System.out.println(rs);
					session.setAttribute("checkDueRs", rs);
					response.sendRedirect("../checkDueRs.jsp");
				}
				
			}

		}if(request.getRequestURI().endsWith("returnBook")){
			String sid = request.getParameter("sid");
			String bid= request.getParameter("bid");
			IssueBookDao book=new IssueBookDaoImpl();
			String status = book.returnBook(Integer.parseInt(sid), bid);
			
			RequestDispatcher rd = null;

			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../bookReturn.jsp");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../bookReturn.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("status", "not found");
				rd = request.getRequestDispatcher("../bookReturn.jsp");
				rd.forward(request, response);
			}
		}

	}

}
