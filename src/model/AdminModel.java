package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Admin;
import controller.User;

public class AdminModel 
{
	static Connection con = DatabaseConnection.getConnection();
	public int register(Admin a) throws SQLException
	{
		String query = "insert into Admin(Username,Email_id,password) values(?,?,?);";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, a.getUsername());
		pst.setString(2, a.getEmail_id());
		pst.setString(3, a.getPass_word());
		int rows = pst.executeUpdate();
		return rows;	
	}
	public Admin loginCheck(Admin a) throws SQLException {
		String query = "Select Email_id,password from Admin where Email_id=?;";
		PreparedStatement st = con.prepareStatement(query);	
		st.setString(1, a.getEmail_id());
		ResultSet rs = st.executeQuery();
		Admin w = new Admin();
		while(rs.next())
		{
			String mail = rs.getString(1);
			String password = rs.getString(2);
			w.setEmail_id(mail);
			w.setPass_word(password);
			return w;
		}
		return null;
	}
	public ArrayList<Admin> displayAdmin() throws SQLException {
		ArrayList<Admin> admin = new ArrayList<>();
		String query = "select * from Admin;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			Admin m = new Admin();
			m.setId(rs.getInt(1));
			m.setUsername(rs.getString(2));
			m.setEmail_id(rs.getString(3));
			m.setPass_word(rs.getString(4));
			admin.add(m);
		}
		return admin;
	}
	public int delete(int value) throws SQLException {
		String query = "delete from Admin where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,value);
		int rows = pst.executeUpdate();
		return rows;
	}
	public int modify(Admin p) throws SQLException {
		String query = "update Admin set password = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, p.getPass_word());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}

}
