package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.db;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(
		urlPatterns = { "/loginServlet" }, 
		initParams = { 
				@WebInitParam(name = "Author", value = "Mann", description = "18DCS074")
		})
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    String n=request.getParameter("email");  
	    String p=request.getParameter("password");
	    
		       
        try {
			if(db.validate(n,p)==true) {
				System.out.println("Logged in!");
				String name = db.getName(n);
				request.setAttribute("Semail",n);
				request.setAttribute("Sname",name);
//				System.out.println(name);
				RequestDispatcher rd=request.getRequestDispatcher("/regWelcome.jsp");  
			    rd.include(request, response);  
			}else{  
			    out.println("Sorry! email or Password is incorrect!");
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
