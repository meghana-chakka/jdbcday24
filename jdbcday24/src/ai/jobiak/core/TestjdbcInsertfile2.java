package ai.jobiak.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.lang.*;

public class TestjdbcInsertfile2 {

	public static void main(String[] args)throws SQLException,IOException {
		
		
		//1.Connect with Driver Manager
				String userName = "root";
				String password = "admin";
				String url = "jdbc:mysql://localhost:3306/world";
		   	    Connection con = DriverManager.getConnection(url,userName, password);
					
					    String FilePath = "movielist.txt";
		 				int batchSize =20;
		                String sql ="insert into movielist values (?,?,?,?,?,?,?,?)";
			            PreparedStatement pstatement = con.prepareStatement(sql);
			 
			            BufferedReader lineReader = new BufferedReader(new FileReader(FilePath));
			            String lineText = null;
			            int count = 0;
			            lineReader.readLine(); // skip header line 
			            while ((lineText = lineReader.readLine()) != null) {
			                String[] data = lineText.split(",");
			           
			                String moviecode = data[0];
			                String moviename = data[1];	
			                String hero = data[2];
			                String heroine = data[3];
			                String director = data[4];
			                String releaseddate = data[5];
			                String panImovie = data[6];
			                String boxoffrating = data[7];
			                pstatement.setString(1,moviecode);
			                pstatement.setString(2,moviename);
			                pstatement.setString(3,hero);
			                pstatement.setString(4,heroine);
			                pstatement.setString(5,director);
			                pstatement.setString(6,releaseddate);
			                pstatement.setString(7,panImovie);
			                pstatement.setString(8,boxoffrating);
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
