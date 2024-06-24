package model;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;

import controller.Order;
import controller.Product;

public class ProductModel {
	static Connection con = DatabaseConnection.getConnection();
	public int sentId(int id) throws SQLException {
		String query = "select id from product where company_id = ?;";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			id = rs.getInt(1);
		}
		return id;
	}
	
	public void insertProduct(Product p) throws SQLException {
	     CompanyModel c = new CompanyModel();
	     int id = c.selectId(p);
	     String query = "insert into product(product_name,company_id,product_variety,price,product_Available) values(?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, p.getProduct_name());
			pst.setInt(2, id);
			pst.setString(3, p.getProduct_variety());
			pst.setDouble(4, p.getPrice());
			pst.setInt(5, p.getProduct_Available());
		    int rows = pst.executeUpdate();
		    System.out.println("The property is added successfully!!....");
	}

	public ArrayList<Product> viewProduct(int id) throws SQLException 
	{
		ArrayList<Product>  product = new ArrayList<>();
		String query = "select * from product where company_id = ?; ";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			Product al = new Product();
			al.setProduct_name(rs.getString("product_name"));
			al.setCompany_name(rs.getString("company_id"));
			al.setProduct_variety(rs.getString("product_variety"));
			al.setPrice(rs.getDouble("price"));
			al.setProduct_Available(rs.getInt("product_Available"));
			product.add(al);
		}
 		return product;
		
		
	}

	public void deleteProduct(Product p, String name, String confirm) throws SQLException {
		   CompanyModel c = new CompanyModel();
		   int id = c.getId(name);
		   String query = "delete from product where company_id = ? && id = ?;";
		   PreparedStatement st = con.prepareStatement(query);
		   st.setInt(1,id);
		   st.setInt(2, p.getId());
		   if(confirm.equals("yes")) {
			   int rows = st.executeUpdate();
			   System.out.println("The record is deleted Successfully");
			   }
			   else
			   {
				   System.out.println("The record is not Deleted");
			   }
	}

//	public void modify(Product p) 
//	{
//		 String query = "UPDATE product" + " SET " + p.getColumnToUpdate() + " = ? WHERE id = " + "?";
//		 try (PreparedStatement pst = con.prepareStatement(query)) {
//		     pst.setInt(1, p.getNewValue());
//		     pst.setInt(2, p.getId());
//		     int rows = pst.executeUpdate();
//		     System.out.println(rows + " record(s) updated.");
//		 } catch (SQLException e) {
//		     System.err.println("Error modifying record: " + e.getMessage());
//		 }	
//		
//	}

	public ArrayList<Product> displayItems() throws SQLException {
		 ArrayList<Product> products = new ArrayList<>();
		 String query = "select * from product; ";
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(query);
		 while(rs.next())
		 {
			Product al = new Product();
			al.setProduct_name(rs.getString("product_name"));
			al.setCompany_name(rs.getString("company_id"));
			al.setProduct_variety(rs.getString("product_variety"));
			al.setPrice(rs.getDouble("price"));
			al.setProduct_Available(rs.getInt("product_Available"));
			products.add(al);
		 }
		 return products;
		
		  
	}

	public double selectedItems(ArrayList<Integer> items, ArrayList<Integer> quantity) throws SQLException {
		double total=0;
		int flag=0;
		int j=0;
		
		for(int i:items)
		{
			double sum=1;
			int value = quantity.get(j);
			j++;
			String query1 = "select product_Available from product where id = "+i;
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);
			while(rs1.next())
			{
				int x = rs1.getInt(1);
				if(x==0)
				{
					flag=1;
					System.out.println("__"+i+" product is not available__");
				}
			}
			String query = "select product_variety,price from product where id = "+i;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next() && flag==0)
			{
				System.out.println("The product is : " + rs.getString(1));
				System.out.println("The price is : " +rs.getInt(2));
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				sum = value * rs.getInt(2);
				total = total + sum;
			}
			
		}
		return total;
	}

	public ArrayList<Order> updateQuantity(ArrayList<Integer> items, int id, double total, ArrayList<Integer> quantity) throws SQLException
	{
		ArrayList<Order> bl = new ArrayList<>();
		for(int i=0;i<items.size();i++)
		{
			int value = items.get(i);
			int qty = quantity.get(i);
			String query = "select product_Available from product where id = "+value;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			int available=0;
			while(rs.next())
			{
				available = rs.getInt(1);
			}
			int status = available - qty;
			String query1 = "update product set product_Available = ? where id = ?";
			PreparedStatement pst = con.prepareStatement(query1);
			pst.setInt(1, status);
			pst.setInt(2, value);
			int rows = pst.executeUpdate();
			System.out.println("The value is updated");
			OrderModel o = new OrderModel();
			bl = o.displayOrder(id);
     	}
		return bl;
		
	}

	public int locationChange(Product p) throws SQLException {
		String query = "update product set product_name = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, p.getProduct_name());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}

	public int priceChange(Product p) throws SQLException {
		String query = "update product set price = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setDouble(1,p.getPrice());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
		
	}

	public int availableChange(Product p) throws SQLException {
		String query = "update product set product_Available = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,p.getProduct_Available());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}

	public int varietyChange(Product p) throws SQLException {
		String query = "update product set product_variety = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,p.getProduct_variety());
		pst.setInt(2, p.getId());
		int rows = pst.executeUpdate();
		return rows;
	}



} 
