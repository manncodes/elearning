package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;




@MultipartConfig(maxFileSize = 16177215)
/**
 * Servlet implementation class registerSevlet
 */
@WebServlet(
		urlPatterns = { "/registerSevlet" }, 
		initParams = { 
				@WebInitParam(name = "Author", value = "Mann Patel", description = "18DCS074")
		})
public class registerSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		String FName = request.getParameter("fname");
		String LName = request.getParameter("lname");
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning", "root", "");
   
    		PreparedStatement ps=con.prepareStatement("insert into student(fname,lname,email,password) values(?,?,?,?)");  
    		ps.setString(1,FName);
    		ps.setString(2,LName);
    		ps.setString(3,Email);
    		ps.setString(4,Password);
    		
    		if(ps.executeUpdate()>0) {
    			request.setAttribute("Sname",FName);
    			RequestDispatcher rd=request.getRequestDispatcher("/regWelcome.jsp");  
			    rd.include(request, response);  
    		}else {
    			out.println("<b>Sign Up Failed! Please Try Again!</b>");
    			RequestDispatcher rd=request.getRequestDispatcher("/register.html");  
			    rd.include(request, response);  
    		}    		
		}
		catch(Exception e) {
			out.println(e);
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
