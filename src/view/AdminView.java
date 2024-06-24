package view;

import controller.Admin;
import controller.Company;
import controller.Order;
import controller.Product;
import controller.User;
import controller.order_items;

import java.sql.SQLException;
import java.util.*;
public class AdminView
{
	Scanner sc = new Scanner(System.in);

	public void display() throws SQLException 
	{
		System.out.println("Enter the choice :    ");
		System.out.println(" -----------------------------");
		System.out.println("|      Enter 1 to login       |");
		System.out.println("|      Enter 2 to Exit        |");
		System.out.println(" -----------------------------");
		int choice = sc.nextInt();
		switch(choice)
		{
		    case 1:
		    {
		    	login();
		    	break;
		    }
		    case 2:
		    {
		    	break;
		    }
		    default:
		    	System.out.println("Enter a valid option");
		}
		
	}

	private void login() throws SQLException {
		System.out.println("Enter the valid email id: ");
		String email_id = sc.next();
		System.out.println("Enter the password: ");
		String pass_word = sc.next();
		Admin  a = new Admin();
		a.setEmail_id(email_id);
		a.setPass_word(pass_word);
		Admin s = new Admin();
		Admin so = s.checkLogin(a);
		if(so!=null && a.getPass_word().equals(so.getPass_word()))
			{
				System.out.println("Login Successfully!!");
				customize();
			}
			else
			{
				System.out.println("Login failed");
			}
		
	}

	private void customize() throws SQLException
	{
		System.out.println("__`Welcome you as an administrator`__");
		System.out.println("Enter the option to customize the record in a optimized way");
		System.out.println(" +--------------------------------------+");
		System.out.println("|           Enter 1 to add              |");
		System.out.println("|           Enter 2 to delete           |");
		System.out.println("|           Enter 3 to display          |");
		System.out.println("|           Enter 4 to modify           |");
		System.out.println("|           Enter 5 to exit             |");
		System.out.println(" +--------------------------------------+");
		int choice = sc.nextInt();
		switch(choice)
		{
		    case 1:
	     	{
			    add();
		 	    break;
		    }
		    case 2:
		    {
		    	delete();
		    	break;
		    }
		    case 3:
		    {
		    	view();
		    	break;
		    }
		    case 4:
		    {
		    	modify();
		    	break;
		    }
		    case 5:
		    {
		    	break;
		    }
	     	default:
	     		System.out.println("Enter a valid option");
		}
		
		
	}

	private void delete() throws SQLException {
		System.out.println("Enter the id to delete :");
		int value = sc.nextInt();
		Admin n = new Admin();
		int rows = n.delete(value);
		if(rows>0)
			System.out.println("The record is deleted successfully");
		else
			System.out.println("The record is not deleted successfully");
		
	}

	private void modify() throws SQLException {
		System.out.println("Enter the new value: ");
		String newValue = sc.next();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Admin p = new Admin();
		p.setPass_word(newValue);
		p.setId(idValue);
		Admin b = new Admin();
		int rows = b.modify(p);
		if(rows>0)
			System.out.println("The password is updated successfully");
		else
			System.out.println("The password is not updated successfully");
	}

	private void add() throws SQLException 
	{
		register();
		
	}

	


	private void view() throws SQLException 
	{
		System.out.println("Enter the choice to fill table name: ");
		System.out.println(" +--------------------------------------+");
		System.out.println("|             1.User                    |");
		System.out.println("|             2.product                 |");
		System.out.println("|             3.company_description     |");
		System.out.println("|             4.Admin                   |");
		System.out.println("|             5.Orders                  |");
		System.out.println("|             6.Order_item              |");
		System.out.println("|             7.Exit                    |");
		System.out.println(" +--------------------------------------+");
		int t_name = sc.nextInt();
		switch(t_name)
		{
		   case 1:
		   {
			   displayUser();
			   break;
		   }
		   case 2:
		   {
			 displayProduct();
			   break;
		   }
		   case 3:
		   {
			  displayCompany();
			   break;
		   }
		   case 4:
		   {
			   displayAdmin();
			   break;
		   }
		   case 5:
		   {
			   displayOrder();
			   break;
		   }
		   case 6:
		   {
			   displayItems();
			   break;
		   }
		   case 7:
			   break;
		   default:
			   System.out.println("Enter a valid Option");
		}

	}

	private void displayItems() throws SQLException {
		Admin m = new Admin();
		ArrayList<order_items> al = m.displayItems();
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Item ID", "Order ID", "Product ID", "Quantity", "Price");
		System.out.println("-----------------------------------------------------------------");
		for (order_items o : al) {
		    System.out.printf("| %-10d | %-10d | %-10d | %-10d | %-10.2f |\n", o.getItem_id(), o.getOrder_id(), o.getProduct_id(), o.getQuantity(), o.getPrice());
		}
		System.out.println("-----------------------------------------------------------------");
	}

	private void displayOrder() throws SQLException {
		Admin m = new Admin();
		ArrayList<Order> al = m.displayOrder();
		System.out.println();
		System.out.println("+--------------------------------------+----------------------+----------------------+----------------------+");
		System.out.printf("| %-8s | %-20s | %-20s | %-15s | %-20s | %-30s |\n", "Order ID", "Order Date", "Customer ID", "Quantity","Price","Status");
		System.out.println("+--------------------------------------+----------------------+----------------------+----------------------+");

		for (Order o : al) {
		    		 System.out.printf("| %-8d | %-20s | %-20d | %-15d | %-20.2f | %-30s |\n",
		                      o.getOrder_id(),
		                      o.getOrder_date(),
		                      o.getCustomer_id(),
		                      o.getQuantity(),
		                      o.getPrice(),
		                      o.getStatus());
		    System.out.println("+--------------------------------------+----------------------+----------------------+----------------------+");
		}

		

		
	}

	private void displayAdmin() throws SQLException {
		Admin s = new Admin();
		ArrayList<Admin> al = s.displayAdmin();
		System.out.println();
		System.out.println("+--------------------------------------+----------------------+--------------------------+");
		System.out.printf("| %-5s | %-20s | %-30s | %-20s |\n", "ID", "Username", "Email","Password");
		System.out.println("+--------------------------------------+----------------------+--------------------------+");

		for (Admin m : al) {
		    System.out.printf("| %-5d | %-20s | %-30s | %-20s |\n",
		                      m.getId(),
		                      m.getUsername(),
		                      m.getEmail_id(),
		                      m.getPass_word());
		    System.out.println("+--------------------------------------+----------------------+--------------------------+");

		}

		
		
	}

	private void displayCompany() throws SQLException {
		Admin m = new Admin();
		ArrayList<Company> al = m.displayCompany();
		System.out.println();
		for (int i=0;i<al.size();i++) {
		      Company company = al.get(i);
		      System.out.println("        The  Id                :" +company.getId());
		      System.out.println("        The  Username          :" +company.getUsername());
		      System.out.println("        The  Email             :" +company.getEmail());
		      System.out.println("        The  Password          :" +company.getPassword());
		      System.out.println("        The  Company name      :" +company.getCompany());
		      System.out.println("        The  Company details   :" +company.getDetails());
		      System.out.println("        The  Company Usb       :" +company.getUsb());
		      System.out.println("        The  Contact           :" +company.getContact());
		      System.out.println("        The  Location          :" +company.getLocation());
		      System.out.println("     +-----------------------------------------------------------------------+"); 
		    }
	}

	private void displayProduct() throws SQLException {
		Admin m = new Admin();
		ArrayList<Product> cl = m.displayProduct();
		System.out.println();
		System.out.println("+---------------------------------------------------------------------------------------------------+");
		System.out.printf("| %-20s | %-20s | %-20s | %-10s | %-15s |\n", "Product Name", "Company id", "Variety", "Price", "Available");
		System.out.println("+---------------------------------------------------------------------------------------------------+");

		for (int i = 0; i < cl.size(); i++) {
		    Product a = cl.get(i);
		    System.out.printf("| %-20s | %-20s | %-20s | %-10.2f | %-15s |\n", a.getProduct_name(), a.getCompany_name(), a.getProduct_variety(), a.getPrice(), a.getProduct_Available());
		}

		System.out.println("+---------------------------------------------------------------------------------------------------+");
		System.out.println();
	}

	private void displayUser() throws SQLException 
	{
		Admin m = new Admin();
		ArrayList<User> u = m.displayUser();

		System.out.println();
		System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
		System.out.printf("| %-3s | %-9s | %-20s | %-9s | %-45s | %-9s |\n", "ID", "Username", "Email", "Password", "Address", "Contact");
		System.out.println("+-----------------------------------------------------------------------------------------------------------------+");

		for (User user : u) {
		    System.out.printf("| %-3d | %-9s | %-20s | %-9s | %-45s | %-9s |\n",
		                      user.getId(),
		                      user.getUsername(),
		                      user.getEmail(),
		                      user.getPassword(),
		                      user.getAddress(),
		                      user.getContact());
		    System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
		}

	}

	private void register() throws SQLException 
	{
		System.out.println("Enter Username: ");
		String username = sc.next();
		System.out.println("Enter the valid email id: ");
		String email_id = sc.next();
		System.out.println("Enter the password: ");
		String pass_word = sc.next();
		Admin  a = new Admin();
		a.setUsername(username);
		a.setEmail_id(email_id);
		a.setPass_word(pass_word);
		Admin u = new Admin();
		int rows = u.register(a);
		if(rows > 0)
		{
			System.out.println("The account is created successfully");
		}
		else
		{
			System.out.println("The account is not created Successfully");
		}
		
	}

	
}
