package db;

import java.sql.*;

public class db{
       
   
    public static boolean validate(String name,String pass){  
    	
    	boolean status=false;  
    	
    	try{  
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning", "root", "");
    		
    	      
    	PreparedStatement ps=con.prepareStatement(  
    	"select * from student where email=? and password=?");  
    	ps.setString(1,name);  
    	ps.setString(2,pass);  
    	      
    	ResultSet rs=ps.executeQuery();  
    	status=rs.next(); 
    	
    	System.out.println("status of rs.next():"+status);
    	          
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}  
    	
    	return status;  
    	
    }
    
    public static String validateEmail(String email){  
    	
    	Boolean status = false;	
    	String pswd = "";
    	
    	try{  
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning", "root", "");
    		
    	      
    	PreparedStatement ps=con.prepareStatement(  
    	"select password from student where email=?");  
    	ps.setString(1,email);  
    	  
    	      
    	ResultSet rs=ps.executeQuery();  
    	status=rs.next(); 
    	pswd = rs.getString(1);
    	
    	System.out.println("status of rs.next():"+status);
    	System.out.println("pswd(db):"+pswd);
    	          
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}  
    	
		return pswd; 
    	
    }

public static String getName(String email){  
    	
    	String name = "";  
    	
    	try{  
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning", "root", "");
    		
    	      
    	PreparedStatement ps=con.prepareStatement(  
    	"select fname from student where email=?");  
    	ps.setString(1,email);  
  
    	ResultSet rs=ps.executeQuery();
    	rs.next();
    	
    	name=rs.getString(1); 
    	
    	System.out.println("name:"+name);
    	          
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}  
    	
    	return name;  
    	
    }
    
    
//    
//    public static void main(String args[]) {
//    	validateEmail("manncodes@gmail.com");
//    }

}  

