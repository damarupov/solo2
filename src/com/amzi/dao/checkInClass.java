package com.amzi.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkInClass
 */
@WebServlet("/checkInClass")
public class checkInClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static int currentvalue;
	public static String name;
	public static String pass;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn1") != null)
		{
			LoginDao.incrementEntry(name, pass, currentvalue + 1);
		}
		
		request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
	}
	
}
