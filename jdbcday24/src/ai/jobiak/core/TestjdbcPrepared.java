package ai.jobiak.core;


import java.sql.*;
public class TestjdbcPrepared {

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
		
		for(int i=0;i<names.length;i++) {
			PreparedStatement pst=con.prepareStatement("insert into customer values(?,?,?)");
			pst.setInt(1,765);
			pst.setString(2,names[i]);
			pst.setDouble(3, deposits[i]);
			
			int count =pst.executeUpdate();
			System.out.println(count+"records updated");
		}
		

	}

}
