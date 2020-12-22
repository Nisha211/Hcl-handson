package org.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		Statement statement=null;
		ResultSet result=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		if(connection!=null)
		{
			statement=connection.createStatement();
			System.out.println("database connection successful");
			
		}
		statement.close();
		connection.close();
	}
}




