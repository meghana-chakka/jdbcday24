package jdbcday24;

import java.sql.*;


public class ModifyResultSet3 {

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
		
		
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		//generic ->both ddl,dml,tcl(common or wider or super)
		//String selectSql="select * from customer";
		String selectSql="select * from customer";
		
		ResultSet rs =st.executeQuery(selectSql);
	//read only and frwd only=scrolls only
		//we can't modify the data in resultset&
		//it can move in only one direction
		//pagination
		
		if(rs.next()) {
			rs.absolute(12);
			rs.deleteRow();
			System.out.println(rs.getInt(1)+"::"+rs.getString(2)+"::"+rs.getString(3));
			//when we delete a record,the cursor moves one row up and displays that rescord when we fetch
			
		}
			
	}

}
