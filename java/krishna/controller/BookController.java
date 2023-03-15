package krishna.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import krishna.dao.BookDaoImpl;
import krishna.dto.Book;
import krishna.service.IBookService;
import krishna.servicefactory.BookServiceFactory;

@WebServlet("/BookController/*")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IBookService bkService = BookServiceFactory.getBookService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addbook")) {

			String bid = request.getParameter("bid");
			String bname = request.getParameter("bname");
			String bauthor = request.getParameter("bauthor");
			String bsubject = request.getParameter("bsubject");
			String quantity=request.getParameter("quantity");

			Book book = new Book();

			book.setBauthor(bauthor);
			book.setBid(bid);
			book.setBname(bname);
			book.setBsubject(bsubject);
			book.setQuantity(Integer.parseInt(quantity));

			String status = bkService.addBook(book);

			RequestDispatcher rd = null;
					
			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../insertBook.jsp");
				rd.forward(request, response);
				
			}
			else {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../insertBook.jsp");
				rd.forward(request, response);
			}
			
		}


		if (request.getRequestURI().endsWith("searchBySub")) { 
			String bsubject =request.getParameter("bsubject");
			ResultSet resultSet=null;
			String status = "fail";
			Book book =null;
			BookDaoImpl impl = new BookDaoImpl();
			resultSet = impl.searchBookBySub(bsubject);
			
				if (resultSet != null) {
					status = "success";
					HttpSession session = request.getSession();
					System.out.println(resultSet);
					session.setAttribute("BookSubject", resultSet);
					response.sendRedirect("../BookSubject.jsp");
				}
				
			}
			
			
		
		
		
		if (request.getRequestURI().endsWith("searchByAuthor")) {
			String bauthor = request.getParameter("bauthor");

			Book book = bkService.searchBookByAuthor(bauthor);
			request.setAttribute("book", book);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);

		}
		
		if (request.getRequestURI().endsWith("searchByTitle")) {
			String bname = request.getParameter("bname");

			Book book = bkService.searchBookByTitle(bname);
			request.setAttribute("book", book);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);

		}

	}

}
