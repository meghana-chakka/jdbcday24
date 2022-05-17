package ai.jobiak.core;

import java.sql.*;


public class Testjdbc {

	public static void main(String[] args)throws SQLException {
		//Load the driver
		
		//2.connect with driverManager
		String userName="root";
		String password="admin";
		String url="jdbc:mysql://localhost:3306/world";
		
		
		Connection con=DriverManager.getConnection(url, userName, password);
		System.out.println("Connected to db...........");
		System.out.println(con);
		
		
		Statement st=con.createStatement();
		//String selectSql="select * from customer";
		String selectSql="select * from customer where cusid=661";
		
		ResultSet rs =st.executeQuery(selectSql);
//		
//		while(rs.next()){
//		System.out.println("Data found....");
//		System.out.println(rs.getString(1)+ " :: "+rs.getString(2)+ " :: " +rs.getString(3));
//	}
		
		
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(1));
		System.out.println(rsmd.getColumnName(2));
		System.out.println(rsmd.getColumnName(3));
		  
		
		

		System.out.println(rsmd.getColumnTypeName(1));
		System.out.println(rsmd.getColumnTypeName(2));
		System.out.println(rsmd.getColumnTypeName(3));
		System.out.println(rsmd.getTableName(1));
		System.out.println(rsmd.getCatalogName(1));
		//System.out.println(rsmd.getSchemaName(1));
		
		System.out.println(rsmd.isNullable(1));
		System.out.println(rsmd.getPrecision(1));
		System.out.println(rsmd.getScale(3));
	}

}
