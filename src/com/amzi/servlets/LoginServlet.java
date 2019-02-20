package com.amzi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzi.dao.LoginDao;
import com.amzi.dao.checkInClass;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null) 
        {
        	session.setAttribute("name", n);
        }
        

        if(LoginDao.validate(n, p)){  
        	session.setAttribute("entry", LoginDao.incrementEntry(n));
        	
        	conversion(LoginDao.incrementEntry(n), n, p);
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
            rd.forward(request,response);
        }  
        else{  
            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);  
        }  
        
        out.close();  
    }
    
    
    public void conversion (String current, String name, String pass) 
    {
    	checkInClass.currentvalue = Integer.parseInt(current);
    	checkInClass.name = name;
    	checkInClass.pass = pass;
    	
    	LoginDao.incrementEntry(name, pass, checkInClass.currentvalue + 1);
    }
} 
