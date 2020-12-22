package org.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			if (connection != null) {
				statement = connection.createStatement();
				resultset = statement.executeQuery("select personID,LastName,FirstName,address,city,salary from employeedetails");
				while (resultset.next())
					System.out.println(resultset.getInt(1) + "\t" + resultset.getString(2) + "\t" + resultset.getString(3) + "\t"
							+ resultset.getString(4) + "\t" + resultset.getString(5) + "\t" + resultset.getInt(6));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.close();
		connection.close();
	}

}
