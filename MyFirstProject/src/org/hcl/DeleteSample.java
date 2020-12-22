package org.hcl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteSample {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection connection = null;
		PreparedStatement prepared = null;
		try {
			Class.forName("com.mydql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			if (connection != null) {
				prepared = connection.prepareStatement("delete from building where building_id=?");
				System.out.println("enter the building_id");
				int building_id = Integer.parseInt(br.readLine());
				prepared.setInt(1, building_id);
				int details = prepared.executeUpdate();
				if (details > 0) {
					System.out.println("successfully deleted");
				} else {
					System.out.println("not deleted");
				}
			}
			prepared.close();
			connection.close();
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
