package controller;
import view.UserView;

import java.sql.SQLException;
import java.util.*;

import model.OrderModel;
import model.Order_itemsModel;
import model.ProductModel;
import model.UserModel;
public class User 
{  
	private int id;
	private String username;
    private String email_id;
    private String pass_word;
    private String address;
    private String contact;
    public User()
    {
    	
    }
    public User(String username,String email_id,String pass_word,String address,String contact)
    {
    	this.username = username;
    	this.email_id = email_id;
    	this.pass_word = pass_word;
    	this.address = address;
    	this.contact = contact;
    }
    public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getUsername()
    {
  	  return username;
    }
    
    public void setUsername(String username)
    {
  	  this.username = username;
    }
    
    public String getEmail()
    {
  	  return email_id;
    }
    
    public void setEmail(String email_id)
    {
  	  this.email_id = email_id;
    }
    
    public String getPassword()
    {
  	  return pass_word;
    }
    
    public void setPassword(String pass_word)
    {
  	  this.pass_word = pass_word;
    }
    public String getAddress()
    {
  	  return address;
    }
    
    public void setAddress(String address)
    {
  	  this.address = address;
    }
    public String getContact()
    {
  	  return contact;
    }
    
    public void setContact(String contact)
    {
  	  this.contact = contact;
    }
    
    public void setRegisterDetail(User a) throws SQLException
    {
    	 UserModel u = new UserModel();
    	 u.setRegister(a);
    }
	
	public User checkLogin(User c) throws SQLException
	{
		UserModel dao = new UserModel();
		User w = dao.loginCheck(c);
	    return w;
	}
	public int getUserId(String email_id) throws SQLException {
		UserModel m = new UserModel();
		int value = m.getUserId(email_id);
		return value;
	}
	public ArrayList<Product> displayProduct() throws SQLException {
		ProductModel p = new ProductModel();
		ArrayList<Product> al = p.displayItems();
		return al;
		
		
	}
	public ArrayList<Order> updateQuantity(ArrayList<Integer> items, int id, double total, ArrayList<Integer> quantity) throws SQLException {
		ProductModel o = new ProductModel();
		 ArrayList<Order> al = o.updateQuantity(items,id,total,quantity);
		return al;
	}
	public void orderBill(int id, double total, int noOfQuantity) throws SQLException {
			OrderModel m = new OrderModel();
			m.orderBill(id,total,noOfQuantity);
	}
	public int calculate(ArrayList<Integer> quantity) {
		int sum=0;
		for(int i:quantity)
		{
			sum = sum+i;
		}
		return sum;
	}
	public int retrieveId(int id) throws SQLException {
		OrderModel m = new OrderModel();
		int value = m.retrieveId(id);
		return value;
	}
	public int menu(ArrayList<Integer> items, int id, ArrayList<Integer> quantity, int order_id) throws SQLException {
		Order_itemsModel m = new Order_itemsModel();
		int n = m.menu(items,id,quantity,order_id);
		return n;
	}
	public ArrayList<order_items> displayMenu(int order_id) throws SQLException {
		Order_itemsModel m = new Order_itemsModel();
		ArrayList<order_items> cl = m.displayMenu(order_id);
		return cl;
	}
		
}
