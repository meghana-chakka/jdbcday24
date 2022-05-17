package ai.jobiak.core;


import java.sql.*;
public class TestjdbcPrepared2 {

	public static void main(String[] args)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//2.connect with driver manager
		
		String userName="root";
		String password="admin";
		String url="jdbc:mysql://localhost:3306/world";
		
		Connection con=DriverManager.getConnection(url, userName, password);
		System.out.println("Connected to db...........");
		String names[]= {"Da","Lee","Dea","Fang","Min","Eric","Bob","Alexa"};
		double deposits[]= {200,400,800,900,900,700,600,500,450};
		//update with prepared statement
		
			PreparedStatement pst=con.prepareStatement("update customer set balance=balance+?");
			pst.setInt(1,0);
			
			int count =pst.executeUpdate();
			System.out.println(count+"records updated");
		}
		

	}


