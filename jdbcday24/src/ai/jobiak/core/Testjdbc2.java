package ai.jobiak.core;
import java.sql.*;

public class Testjdbc2 {

	public static void main(String[] args) throws SQLException{
		
		String userName="root";
		String password="admin";
		String url="jdbc:mysql://localhost:3306/world";
		
		
		Connection con=DriverManager.getConnection(url, userName, password);
		System.out.println("Connected to db...........");
		System.out.println(con);
		DatabaseMetaData dmd = con.getMetaData();
		System.out.println(dmd.getDriverName());
		System.out.println(dmd.getDriverVersion());
		System.out.println(dmd.getDatabaseProductName());

	}

}
