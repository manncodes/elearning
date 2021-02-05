package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
		
		
		Class.forName("com.mysql.jdbc.Driver");
        // making connection to database:
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning", "root", "");
        
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("update student set fname=?,lname=?,password=? where email=?");
        ps.setString(1,fname);
        ps.setString(2,lname);
        ps.setString(3,password);
        ps.setString(4,email);
        
        int rowsaffected = ps.executeUpdate();
        
       out.println(rowsaffected+" rows affected.");
		}
		catch(Exception e) {
			System.out.println(e);
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
