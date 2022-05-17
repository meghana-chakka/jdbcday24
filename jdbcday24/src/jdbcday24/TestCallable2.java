package jdbcday24;

import java.sql.*;


public class TestCallable2 {

	public static void main(String[] args)throws SQLException {
		//Load the driver
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//2.connect with driverManager
		String userName="root";
		String password="admin";
		String url="jdbc:mysql://localhost:3306/world";
		
		
		Connection con=DriverManager.getConnection(url, userName, password);//OLTP,backup,warehouse
		System.out.println("Connected to db...........");
		System.out.println(con);
		
		//callable statement->executing->functions,procedures and Ref cursors db objts
		//procedure updatebalance(cusid,ammount)updates the balance of the customer
		
		
		CallableStatement cs = con.prepareCall("{?= call addbalance(?,?)}");
		cs.registerOutParameter(1,Types.BOOLEAN);
	
		cs.setInt(1,4000);
		cs.setDouble(1,2000);
		cs.executeUpdate();
		System.out.println(cs.getBoolean(1));
		
		
			
	}

}
