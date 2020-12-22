package org.hcl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class PreparedStatementEg {

	public static void main(String[] args) {
		Connection connection=null;
		//Statement statement=null;
		PreparedStatement prepared=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int building_id,floors;
		String ownerName,building_type;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			if(connection!=null) {
				prepared=connection.prepareStatement("insert into building(building_id,ownerName,building_type,floors) values(?,?,?,?)");
				System.out.println("enter the building details");
				building_id=Integer.parseInt(br.readLine());
				ownerName=br.readLine();
				building_type=br.readLine();
				floors=Integer.parseInt(br.readLine());
				prepared.setInt(1, building_id);
				prepared.setString(2, ownerName);
				prepared.setString(3, building_type);
				prepared.setInt(4, floors);
				int details=prepared.executeUpdate();
				if(details>0)
					System.out.println("successfully inserted");
				else
					System.out.println("not inserted");

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
