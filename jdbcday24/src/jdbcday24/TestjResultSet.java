package jdbcday24;

import java.sql.*;


public class TestjResultSet {

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
		
		
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//generic ->both ddl,dml,tcl(common or wider or super)
		//String selectSql="select * from customer";
		String selectSql="select * from customer";
		
		ResultSet rs =st.executeQuery(selectSql);
	//read only and frwd only=scrolls only
		//we can't modify the data in resultset&
		//it can move in only one direction
		//pagination
		
		//while(rs.next()) {
			rs.afterLast();
			rs.previous();
			System.out.println(rs.getString(1)+ " :: "+rs.getString(2)+ " :: " +rs.getString(3));
			rs.first();
			System.out.println(rs.getString(1)+ " :: "+rs.getString(2)+ " :: " +rs.getString(3));
			rs.next();
			System.out.println(rs.getString(1)+ " :: "+rs.getString(2)+ " :: " +rs.getString(3));
            rs.absolute(4);//with ref to first record
            System.out.println(rs.getString(1)+ " :: "+rs.getString(2)+ " :: " +rs.getString(3));
            rs.absolute(8);//with ref to first record
            System.out.println(rs.getString(1)+ " :: "+rs.getString(2)+ " :: " +rs.getString(3));
		
			
			
			
			//}
//		
//		ResultSetMetaData rsmd = rs.getMetaData();
//		System.out.println(rsmd.get);
//		
		
//		mail boxes->pagination
//		while(rs.next()){
//		System.out.println("Data found....");
//		System.out.println(rs.getString(1)+ " :: "+rs.getString(2)+ " :: " +rs.getString(3));
//	}
		
//		

//		System.out.println(rsmd.getColumnCount());
//		System.out.println(rsmd.getColumnName(1));
//		System.out.println(rsmd.getColumnName(2));
//		System.out.println(rsmd.getColumnName(3));
//		  
//		
//		
//
//		System.out.println(rsmd.getColumnTypeName(1));
//		System.out.println(rsmd.getColumnTypeName(2));
//		System.out.println(rsmd.getColumnTypeName(3));
//		System.out.println(rsmd.getTableName(1));
//		System.out.println(rsmd.getCatalogName(1));
//		//System.out.println(rsmd.getSchemaName(1));
//		
//		System.out.println(rsmd.isNullable(1));
//		System.out.println(rsmd.getPrecision(1));
//		System.out.println(rsmd.getScale(3));
	}

}
