package model;

import java.sql.*;
import java.util.ArrayList;

import controller.order_items;

public class Order_itemsModel {
	static Connection con = DatabaseConnection.getConnection();
	public int menu(ArrayList<Integer> items, int id, ArrayList<Integer> quantity, int order_id) throws SQLException {
		int rows = 0;
		for(int i=0;i<items.size();i++)
		{
			int value = items.get(i);
			int qvalue = quantity.get(i);
			String query = "select price from product where id = "+value;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			double price = 0;
			double price1 =1;
			while(rs.next())
			{
				price = rs.getDouble(1);
			}
			price1 = price * qvalue;
			String query1 = "insert into order_items(order_id,product_id,quantity,price) values(?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(query1);
			pst.setInt(1,order_id);
			pst.setInt(2,value);
			pst.setInt(3, qvalue);
			pst.setDouble(4, price1);
			rows = pst.executeUpdate();
		}
		return rows;
	}
	public ArrayList<order_items> displayMenu(int order_id) throws SQLException {
		ArrayList<order_items> items = new ArrayList<>();
		String query = "select * from order_items where order_id = "+order_id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			order_items o = new order_items();
			o.setItem_id(rs.getInt(1));
			o.setOrder_id(rs.getInt(2));
			o.setProduct_id(rs.getInt(3));
			o.setQuantity(rs.getInt(4));
			o.setPrice(rs.getDouble(5));
			items.add(o);
		}
		return items;
	}
	public ArrayList<order_items> displayItems() throws SQLException {
		ArrayList<order_items> items = new ArrayList<>();
		String query = "select * from order_items";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			order_items o = new order_items();
			o.setItem_id(rs.getInt(1));
			o.setOrder_id(rs.getInt(2));
			o.setProduct_id(rs.getInt(3));
			o.setQuantity(rs.getInt(4));
			o.setPrice(rs.getDouble(5));
			items.add(o);
		}
		return items;
		
	}

}
