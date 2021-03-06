package com.banking.ibs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.ibs.dao.serviceImpl.LoginPageDAOImpl;



@WebServlet("/login")
public class LoginPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginPageController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter writer = response.getWriter();
		LoginPageDAOImpl loginDAO = new LoginPageDAOImpl();
		HashMap<String, String> cred_map = loginDAO.getUserCredData();

		if(cred_map.keySet().contains(username) && cred_map.get(username).equals(password)) {

			//response.sendRedirect("home.html"); // static [pre-defined html file]

			//writer.write("<h1>Congratulations!</h1>");  // dynamic [on the fly html]
			//writer.write("<h2>Successfully logged in!</h2>");

			//-------------------------------------------------------------------------

			//request scope
			//request.setAttribute("username", username);

			//session scope
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			// application scope
			//ServletContext context =  this.getServletContext();
			//context.setAttribute("username", username);

			// continue the same request cycle
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{
			response.sendRedirect("invalidCredentials.html"); // static [pre-defined html file]

			//writer.write("<h1>Invalid Credentials!</h1>"); // dynamic [on the fly html]
			//writer.write("<h2>Please Re-login!</h2>");

		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
