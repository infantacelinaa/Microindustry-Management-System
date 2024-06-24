package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.User;
import controller.Company;
import controller.Product;

public class CompanyModel {
	static Connection con = DatabaseConnection.getConnection();
	public void RegisterCompany(Company c) throws SQLException 
	{
			String query = "insert into company_description(Username,Email_id,Password,company_name,company_description,company_USB,contact,location) values(?,?,?,?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, c.getUsername());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getPassword());
			pst.setString(4, c.getCompany());
			pst.setString(5, c.getDetails());
			pst.setString(6, c.getUsb());
			pst.setString(7, c.getContact());
			pst.setString(8, c.getLocation());
			
			int rows = pst.executeUpdate();
			System.out.println("The account is created successfully");
				
		
	}
	public Company loginCompany(Company c) throws SQLException 
	{
		String query = "Select Email_id,Password from company_description where Email_id=?;";
		PreparedStatement st = con.prepareStatement(query);	
		st.setString(1, c.getEmail());
		ResultSet rs = st.executeQuery();
		Company w = new Company();
		while(rs.next())
		{
			String mail = rs.getString(1);
			String password = rs.getString(2);
			w.setEmail(mail);
			w.setPassword(password);
			return w;
		}
		return null;
	}
	
	public int idCheck(String name) throws SQLException {
		int id=0;
		String query1 = "select id from company_description where company_name = ?";
		PreparedStatement st1 = con.prepareStatement(query1);
		st1.setString(1, name);
		ResultSet rs1 = st1.executeQuery();
		while(rs1.next())
		{
			id = rs1.getInt(1);
		}
		ProductModel p = new ProductModel();
		int value = p.sentId(id);
		return value;
	}
	
	public int selectId(Product p) throws SQLException {
		String query1 = "select id from company_description where company_name = ?";
	    PreparedStatement pst1 = con.prepareStatement(query1);
	    pst1.setString(1,p.getCompany_name());
	    ResultSet rs1 = pst1.executeQuery();
	    int id =0;
	    while (rs1.next())
	    {
	    	id = rs1.getInt(1);
	    }
		return id;
	}
	public ArrayList<Product> getIdValue(String name) throws SQLException {
		String query1 = "select id from company_description where company_name = ?";
	    PreparedStatement pst1 = con.prepareStatement(query1);
	    pst1.setString(1, name);
	    ResultSet rs1 = pst1.executeQuery();
	    int id=0;
	    while(rs1.next())
	    {
	    	id = rs1.getInt(1);
	    }
//	    System.out.println(id);
	    ProductModel m = new ProductModel();
	    ArrayList <Product> al = m.viewProduct(id);
	    return al;
	}
	public int getId(String name) throws SQLException {
		String query1 = "select id from company_description where company_name = ?";
	    PreparedStatement pst1 = con.prepareStatement(query1);
	    pst1.setString(1, name);
	    ResultSet rs1 = pst1.executeQuery();
	    int id=0;
	    while(rs1.next())
	    {
	    	id = rs1.getInt(1);
	    }

		return id;
	}
	public ArrayList<Company> data(int c_id) throws SQLException {
		ArrayList<Company> company = new ArrayList<>();
		String query1 = "select company_name from company_description where id = ?";
		PreparedStatement st1 = con.prepareStatement(query1);
		st1.setInt(1, c_id);
		ResultSet rs1= st1.executeQuery();
		String c_name = "";
		while(rs1.next())
		{
			c_name = rs1.getString(1);
		}
		String query = "select company_name,company_description,company_usb,contact,location from company_description where company_name = ?;";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, c_name);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			Company c = new Company();
			c.setCompany(rs.getString(1));
			c.setDetails(rs.getString(2));
			c.setUsb(rs.getString(3));
			c.setContact(rs.getString(4));
			c.setLocation(rs.getString(5));
			company.add(c);
		}
		return company;
		
	}
	public ArrayList<Company> displayCompany() throws SQLException {
		ArrayList<Company> company = new ArrayList<>();
		String query = "select * from company_description;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			Company c = new Company();
			c.setId(rs.getInt(1));
			c.setUsername(rs.getString(2));
			c.setEmail(rs.getString(3));
			c.setPassword(rs.getString(4));
			c.setCompany(rs.getString(5));
			c.setDetails(rs.getString(6));
			c.setUsb(rs.getString(7));
			c.setContact(rs.getString(8));
			c.setLocation(rs.getString(9));
			company.add(c);
		}
		return company;
	}
	public int passwordChange(Company p) throws SQLException {
		String query = "update Company_description set Password = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, p.getPassword());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}
	public int usbChange(Company p) throws SQLException {
		String query = "update Company_description set company_USB = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, p.getUsb());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}
	public int locationChange(Company p) throws SQLException {
		String query = "update Company_description set location = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, p.getLocation());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}
	public int contactChange(Company p) throws SQLException {
		String query = "update Company_description set contact = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, p.getContact());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}

}
