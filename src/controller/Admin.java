package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.AdminModel;
import model.CompanyModel;
import model.OrderModel;
import model.Order_itemsModel;
import model.ProductModel;
import model.UserModel;
import controller.order_items;
import controller.Order;
import controller.Company;

public class Admin 
{
	private int id;
	private String username;
	private String email_id;
	private String pass_word;
	
	public Admin() {
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public int register(Admin a) throws SQLException
	{
		AdminModel m = new AdminModel();
		int rows = m.register(a);
		return rows;
	}

	public Admin checkLogin(Admin a) throws SQLException {
		AdminModel n = new AdminModel();
		Admin w = n.loginCheck(a);
		return w;
	}

	public ArrayList<User> displayUser() throws SQLException {
		UserModel n = new UserModel();
		ArrayList<User> u = n.displayUser();
		return u;
	}

	public ArrayList<Product> displayProduct() throws SQLException {
		ProductModel p = new ProductModel();
		ArrayList<Product> al = p.displayItems();
		return al;
	}

	public ArrayList<Company> displayCompany() throws SQLException {
		CompanyModel c = new CompanyModel();
		ArrayList<Company> bl = c.displayCompany();
		return bl;
	}

	public ArrayList<Admin> displayAdmin() throws SQLException {
		AdminModel a = new AdminModel();
		ArrayList<Admin> cl = a.displayAdmin();
		return cl;
	}
	public ArrayList<Order> displayOrder() throws SQLException {
		OrderModel o = new OrderModel();
		ArrayList<Order> dl = o.displayOrder();
		return dl;
	}
	public int delete(int value) throws SQLException 
	{
		AdminModel c = new AdminModel();
		int rows = c.delete(value);
		return rows;
	}
	public int modify(Admin p) throws SQLException {
		AdminModel s = new AdminModel();
		int rows = s.modify(p);
		return rows;
		
		
	}
	public ArrayList<order_items> displayItems() throws SQLException {
		Order_itemsModel n = new Order_itemsModel();
		ArrayList<order_items> al = n.displayItems();
		return al;
	}
	
    
}
