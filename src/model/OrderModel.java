package model;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import controller.Order;

public class OrderModel {
	static Connection con = DatabaseConnection.getConnection();

	public ArrayList<Order> displayOrder() throws SQLException {
		ArrayList<Order> order = new ArrayList<>();
		String query = "select * from orders;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			Order o = new Order();
			o.setOrder_id(rs.getInt(1));
			o.setOrder_date(rs.getString(2));
			o.setCustomer_id(rs.getInt(3));
			o.setQuantity(rs.getInt(4));
			o.setPrice(rs.getDouble(5));
			o.setStatus(rs.getString(6));
			order.add(o);
		}
		return order;
	}

	public ArrayList<Order> displayOrder(int id) throws SQLException {
		ArrayList<Order> order = new ArrayList<>();
		String query = "select * from orders where customer_id= ? order by order_id DESC Limit 1";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			Order o = new Order();
			o.setOrder_id(rs.getInt(1));
			o.setOrder_date(rs.getString(2));
			o.setCustomer_id(rs.getInt(3));
			o.setQuantity(rs.getInt(4));
			o.setPrice(rs.getDouble(5));
			o.setStatus(rs.getString(6));
			order.add(o);
			
			
		}
		return order;
		
	}

	public void orderBill(int id, double total, int noOfQuantity) throws SQLException {
		String query = "insert into orders(order_date,customer_id,quantity,total_price,status) values(?,?,?,?,?);";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
		pst.setInt(2,id);
		pst.setInt(3, noOfQuantity);
		pst.setDouble(4, total);
		pst.setString(5, "order placed");
		int rows = pst.executeUpdate();
//		System.out.println("The order is updated"); 
		
	}

	public int retrieveId(int id) throws SQLException {
		String query = "select order_id from orders where customer_id= ? order by order_id DESC Limit 1";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		int value=0;
		while(rs.next())
		{
			value = rs.getInt(1);
		}
		return value;
		
	}

	
}
