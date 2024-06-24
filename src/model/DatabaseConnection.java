package model;
//package com.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection con = null;

	static
	{
		String url = "jdbc:mysql://localhost:3306/smallscale";
		String user = "root";
		String pass = "cel-2075";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
}
