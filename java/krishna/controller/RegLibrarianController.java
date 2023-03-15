package krishna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import krishna.dto.RegisterLibrarian;
import krishna.service.IRegLibrarianService;
import krishna.servicefactory.regLibrarianServiceFactory;

@WebServlet("/RegLibrarianController/*")
public class RegLibrarianController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IRegLibrarianService regLibrarianService = regLibrarianServiceFactory.getRegLibrarianService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("regLibrarian")) {

			String lname = request.getParameter("lname");
			String lusername = request.getParameter("lusername");
			String lpassword = request.getParameter("lpassword");

			RegisterLibrarian registerLibrarian = new RegisterLibrarian();
			registerLibrarian.setLname(lname);
			registerLibrarian.setLusername(lusername);
			registerLibrarian.setLpassword(lpassword);
			

			String status = regLibrarianService.registerLibrarian(registerLibrarian);

			RequestDispatcher rd = null;
			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../insertLibrarian.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../insertLibrarian.jsp");
				rd.forward(request, response);
			}
		}

	}
}
