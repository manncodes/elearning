package com;

import db.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class courseregServlet
 */
@WebServlet("/courseregServlet")
public class courseregServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseregServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Boolean status=false;
		
		try {
			
			String email = request.getParameter("email");
			int cid = Integer.parseInt(request.getParameter("cid"));
			
			Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning", "root", "");
    		
    	    
	    	PreparedStatement ps=con.prepareStatement(  
	    	"insert into scourse(cid,semail) values(?,?);");  
	    	ps.setInt(1,cid);  
	    	ps.setString(2,email);  
	    	      
	    	ps.executeUpdate();  
	    	
	    	con.prepareStatement("select * from courses where cid=?");
	    	ps.setInt(1,cid);
	    	
	    	ResultSet rs=ps.executeQuery();  
	    	status=rs.next(); 
	    	String cname = rs.getString(2);
	    	String instructor = rs.getString(4);
	    	int clength = rs.getInt(5);

	    	
	    	
	    	out.println("Successfully registered to course: "+cname);
	    	out.println("Your course instructor will be: "+instructor);
	    	out.println("Your course will last "+clength+" weeks long.");
	    	
	    		    	
	    	
			
		}catch(Exception e) {
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
