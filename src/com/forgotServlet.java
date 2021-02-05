package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.db;

import Email.*;

/**
 * Servlet implementation class forgotServlet
 */
@WebServlet("/forgotServlet")
public class forgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
	    
	    String n=request.getParameter("email");  
	    
		       
        try {
        		String s=db.validateEmail(n);
			if(s!=null) {
				System.out.println(s);
//				System.out.println(name);
				Email.SendMail.send(n, s);
				out.println("Password has been successfully sent to your email.");
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
			    rd.include(request, response);  
			}else{  
			    out.println("Sorry! The user having this email doesnt exist.");
			    out.println("<br>");
			    out.println("<br>");
			    RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
			    rd.include(request, response);  
			                  
			    }
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
