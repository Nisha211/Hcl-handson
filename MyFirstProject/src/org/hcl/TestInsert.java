package org.hcl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int building_id,floors;
		String ownerName,building_type;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			if(connection!=null) {
				statement=connection.createStatement();
				System.out.println("enter the building details");
				building_id=Integer.parseInt(br.readLine());
				ownerName=br.readLine();
				building_type=br.readLine();
				floors=Integer.parseInt(br.readLine());
				int details=statement.executeUpdate("insert into building(building_id,ownerName,building_type,floors)values"
						+ "("+building_id+",'"+ownerName+"','"+building_type+"','"+floors+"')");
				if(details>0) {
					System.out.println("successfully inserted");
				}
				else {
					System.out.println("Not inserted");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
