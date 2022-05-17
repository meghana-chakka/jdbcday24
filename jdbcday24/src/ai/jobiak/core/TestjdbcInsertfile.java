package ai.jobiak.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


public class TestjdbcInsertfile {

	public static void main(String[] args)throws SQLException,IOException {
		
		
		//1.Connect with Driver Manager
				String userName = "root";
				String password = "admin";
				String url = "jdbc:mysql://localhost:3306/world";
			   Connection con = DriverManager.getConnection(url,userName, password);
					
					  String FilePath = "courseList.csv";
		 				int batchSize =10;
		 String sql =  "insert into courselist values (?, ?)";
			            PreparedStatement pstatement = con.prepareStatement(sql);
			 
			            BufferedReader lineReader = new BufferedReader(new FileReader(FilePath));
			            String lineText = null;
			            int count = 0;
			            lineReader.readLine(); // skip header line 
			            while ((lineText = lineReader.readLine()) != null) {
			                String[] data = lineText.split(",");
			           
			                String CourseName = data[0];
			                String StudentName = data[1];	                
			                pstatement.setString(1, CourseName);
			                pstatement.setString(2, StudentName);
			                pstatement.addBatch();	 
			              if (count % batchSize == 0) {
			                    pstatement.executeBatch();
			                }
			            }
			 
			           lineReader.close();
			            // execute the remaining queries
			            pstatement.executeBatch();
			 			System.out.println("values Inserted");
			            con.close();

			}


}
