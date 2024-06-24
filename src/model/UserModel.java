package model;
import java.sql.*;
import java.util.ArrayList;

import controller.Product;
import controller.User;
public class UserModel
{
    static Connection con = DatabaseConnection.getConnection();
	public void setRegister(User b) throws SQLException 
	{
		String query = "insert into user(Username,Email_id,Password,Permanent_Address,contact) values(?,?,?,?,?);";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, b.getUsername());
		pst.setString(2, b.getEmail());
		pst.setString(3, b.getPassword());
		pst.setString(4, b.getAddress());
		pst.setString(5, b.getContact());
		int rows = pst.executeUpdate();
		System.out.println("The account is created successfully");
	}
	
	public boolean setLoginDetails(String a) throws SQLException {
		String query = "select Email_id from user where Email_id = ?; ";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,a);
		ResultSet rs = st.executeQuery();
		String mail="";
		while(rs.next())
		{
		  mail = rs.getString(1);
		  return true;
		}
		
		return false;
	}

	public User loginCheck(User c) throws SQLException
	{
		String query = "Select Email_id,Password from user where Email_id=?;";
		PreparedStatement st = con.prepareStatement(query);	
		st.setString(1, c.getEmail());
		ResultSet rs = st.executeQuery();
		User w = new User();
		while(rs.next())
		{
			String mail = rs.getString(1);
			String password = rs.getString(2);
			w.setEmail(mail);
			w.setPassword(password);
			return w;
		}
		return w;
	}

	public int getUserId(String email_id) throws SQLException {
		String query = "select id from user where Email_id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, email_id);
		ResultSet rs = pst.executeQuery();
		int id=0;
		while(rs.next())
		{
			id = rs.getInt(1);
		}
		return id;
	}

	public ArrayList<User> displayUser() throws SQLException 
	{
	    ArrayList<User> product = new ArrayList<>();
	    String query = "select * from user; ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		 while(rs.next())
		 {
			User al = new User();
			al.setId(rs.getInt(1));
			al.setUsername(rs.getString(2));
			al.setEmail(rs.getString(3));
			al.setPassword(rs.getString(4));
			al.setAddress(rs.getString(5));
			al.setContact(rs.getString(6));
			product.add(al);
		 }
		return product;
	}
    
}
