package view;
import java.sql.SQLException;

import java.util.*;
import controller.Product;
import controller.Admin;
import controller.Company;
import controller.User;
public class CompanyView
{ 
	 Scanner sc = new Scanner(System.in);
     static String name = ""; 
	public void display() throws SQLException
	{
		System.out.println("Enter the choice :    ");
		System.out.println(" -----------------------------");
		System.out.println("|      Enter 1 to login       |");
		System.out.println("|      Enter 2 to Register    |");
		System.out.println("|      Enter 3 to Exit        |");
		System.out.println(" -----------------------------");
		int choice = sc.nextInt();
		switch(choice)
		{
		    case 1:
		    {
		    	companyLogin();
		    	break;
		    }
		    case 2:
		    {
		    	    System.out.println("Enter Username: ");
		    		String username = sc.next();
		    		System.out.println("Enter the valid email id: ");
		    		String email_id = sc.next();
		    		System.out.println("Enter the password: ");
		    		String pass_word = sc.next();
		    		System.out.println("Enter the company name: ");
		    		sc.nextLine();
		    		String company = sc.nextLine();
		    		System.out.println("Enter the details: ");
		    		String details = sc.nextLine();
		    		System.out.println("Enter the Unique selling point of a company: ");
		    		String usb = sc.nextLine();
		    		System.out.println("Enter the contact:  ");
		    		String contact = sc.next();
		    		System.out.println("Enter the location");
		    		sc.nextLine();
		    		String location = sc.nextLine();
		    		Company c = new Company();
		    		c.setUsername(username);
		    		c.setEmail(email_id);
		    		c.setPassword(pass_word);
		    		c.setCompany(company);
		    		c.setDetails(details);
		    		c.setUsb(usb);
		    		c.setContact(contact);
		    		c.setLocation(location);
		    		Company o = new Company();
		    		o.setCompanyDetails(c);
		    		companyLogin();
		    	break;
		    }
		    case 3:
		    {
		    	break;
		    }
		}
		
	}

	private void companyLogin() throws SQLException {
		Company c = new Company();
    	System.out.println("Enter the valid email id: ");
		String email_id = sc.next();
		System.out.println("Enter the password: ");
		String pass_word = sc.next();
		c.setEmail(email_id);
		c.setPassword(pass_word);
		Company com = c.loginCompany(c);
		if(com!=null && c.getPassword().equals(com.getPassword()))
		{
			System.out.println("Login Successfully!!");
			displayCompany();
		}
		else
		{
			System.out.println("Login failed");
		}		
	}

	private void displayCompany() throws SQLException 
	{
		System.out.println("______________________________________________");
	   	System.out.println("__We Gladly welcome to this expo ,enjoy it!!__");
	   	System.out.println("______________________________________________");
	   	System.out.println();
	   	System.out.println("Enter the Company Name:  ");
	   	sc.nextLine();
	   	name = sc.nextLine();
	   	
	   	Company o = new Company();
	   	int id = o.idCheck(name);
	   	if(id == 0)
	   		System.out.println("New as a owner,!!Welcome once again, share your product and enjoy the outcome!!");
	   	else
	   		customize(name);
	   	System.out.println(id);
	   	
	}

	private void customize(String name) throws SQLException
	{
		boolean count = true;
		while(count)
		{
		System.out.println("__Enter the choice to customize your records__");
		System.out.println(" ---------------------------------------------- ");
    	System.out.println("|   Enter 1 to insert record                   |");
    	System.out.println("|   Enter 2 to delete record                   |");
    	System.out.println("|   Enter 3 to Display record                  |");
    	System.out.println("|   Enter 4 to Modify record                   |");
    	System.out.println("|   Enter 5 to exit                            |");
    	System.out.println(" ---------------------------------------------- ");
    	int choice = sc.nextInt();
    	switch(choice)
    	{
         	case 1:
    	    {
    		  insert(); 
    		  break;
    	    }
         	case 2:
         	{
         		System.out.println("         Enter the id to delete the record             ");
         		System.out.println("     To view the record , enter 'yes' else 'no'        ");
         		String id = sc.next();
         		if(id.equalsIgnoreCase("yes"))
         		{
         			view(name);
         			int uid = sc.nextInt() ; 
         			Product p = new Product();
         			p.setCompany_name(name);
         			p.setId(uid);
         			Product v = new Product();
         			v.delete(p,name);
         			
         		}
         		else
         		{
         			int uid = sc.nextInt() ; 
     			    Product p = new Product();
     			    p.setCompany_name(name);
     			    p.setId(uid);
     		    	Product v = new Product();
     			   v.delete(p,name);
         		}
        		break;
         	}
         	case 3:
         	{
         		view(name);
         		break;
         	}
         	case 4:
         	{
         		change();
         		break;
         	}
         	case 5:
         	{
         		count=false;
         		break;
         	}
         	default :
         	{
         		System.out.println("Enter a valid Option.");
         		customize(name);
         	}
         		
    	  }
		}
		
	}

	private void change() throws SQLException 
	{
		boolean c=true;
		while(c) {
		System.out.println("Enter the option to modify: ");
		System.out.println(" +-------------------------------------------+");
		System.out.println("|   Enter 1 to modify password                |");
		System.out.println("|   Enter 2 to modify usb of a company        |");	
		System.out.println("|   Enter 3 to location                       |");
		System.out.println("|   Enter 4 to contact                        |");
		System.out.println("|   Enter 5 to product name                   |");
		System.out.println("|   Enter 6 to modify price                   |");
		System.out.println("|   Enter 7 to modify quantity                |");
		System.out.println("|   Enter 8 to modify product variety         |");
		System.out.println("|   Enter 9 to Exit                           |");
		System.out.println(" +-------------------------------------------+");
		int option = sc.nextInt();
		switch(option)
		{
		      case 1:
		      {
		    	  password();
		    	  break;
		      }
		      case 2:
		      {
		    	  usb();
		    	  break;
		      }
		      case 3:
		      {
		    	  location();
		    	  break;
		      }
		      case 4:
		      {
		    	  contact();
		    	  break;
		      }
		      case 5:
		      {
		    	  productChange();
		    	  break;
		      }
		      case 6:
		      {
		    	  priceChange();
		    	  break;
		      }
		      case 7:
		      {
		    	  quantityChange();
		    	  break;
		      }
		      case 8:
		      {
		    	  varietyChange();
		    	  break;
		      }
		      case 9:
		      {
		    	  c=false;
		    	  break;
		      }
		      default:
		    	  System.out.println("Enter a valid option");
		}
	}
	}

	private void varietyChange() throws SQLException {
		System.out.println("Enter the new value: ");
		String newValue = sc.next();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Product p = new Product();
		p.setProduct_variety(newValue);
		p.setId(idValue);
		Product a = new Product();
		int rows = a.modifyVariety(p);
		if(rows>0)
			System.out.println("The value is updated successfully");
		else
			System.out.println("The value is not updated successfully");
	}

	private void quantityChange() throws SQLException {
		System.out.println("Enter the new value: ");
		int newValue = sc.nextInt();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Product p = new Product();
		p.setProduct_Available(newValue);
		p.setId(idValue);
		Product a = new Product();
		int rows = a.modifyQuantity(p);
		if(rows>0)
			System.out.println("The value is updated successfully");
		else
			System.out.println("The value is not updated successfully");
		
	}

	private void priceChange() throws SQLException {
		System.out.println("Enter the new value: ");
		double newValue = sc.nextDouble();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Product p = new Product();
		p.setPrice(newValue);
		p.setId(idValue);
		Product a = new Product();
		int rows = a.modifyPrice(p);
		if(rows>0)
			System.out.println("The price is updated successfully");
		else
			System.out.println("The price is not updated successfully");
		
	}

	private void productChange() throws SQLException {
		System.out.println("Enter the new value: ");
		String newValue = sc.next();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Product p = new Product();
		p.setProduct_name(newValue);
		p.setId(idValue);
		Product a = new Product();
		int rows = a.modifyProduct(p);
		if(rows>0)
			System.out.println("The value is updated successfully");
		else
			System.out.println("The value is not updated successfully");
	}

	private void contact() throws SQLException {
		System.out.println("Enter the new value: ");
		String newValue = sc.next();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Company p = new Company();
		p.setContact(newValue);
		p.setId(idValue);
		Company a = new Company();
		int rows = a.modifyContact(p);
		if(rows>0)
			System.out.println("The contact is updated successfully");
		else
			System.out.println("The contact is not updated successfully");
	}

	private void location() throws SQLException {
		System.out.println("Enter the new value: ");
		String newValue = sc.next();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Company p = new Company();
		p.setLocation(newValue);
		p.setId(idValue);
		Company a = new Company();
		int rows = a.modifyLocation(p);
		if(rows>0)
			System.out.println("The location is updated successfully");
		else
			System.out.println("The location is not updated successfully");
		
	}

	private void usb() throws SQLException {
		System.out.println("Enter the new value: ");
		String newValue = sc.next();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Company p = new Company();
		p.setUsb(newValue);
		p.setId(idValue);
		Company a = new Company();
		int rows = a.modifyUsb(p);
		if(rows>0)
			System.out.println("The value is updated successfully");
		else
			System.out.println("The value is not updated successfully");
		
	}

	private void password() throws SQLException {
		System.out.println("Enter the new value: ");
		String newValue = sc.next();
		System.out.println("Enter the ID of the record to modify: ");
		int idValue = sc.nextInt();
		Company p = new Company();
		p.setPassword(newValue);
		p.setId(idValue);
		Company a = new Company();
		int rows = a.modify(p);
		if(rows>0)
			System.out.println("The password is updated successfully");
		else
			System.out.println("The password is not updated successfully");
		
	}

	private void view(String name) throws SQLException
	{
		Company c = new Company();
		ArrayList<Product> cl = c.idTodelete(name);
        System.out.println();
		System.out.println("+---------------------------------------------------------------------------------------------------+");
		System.out.printf("| %-20s | %-20s | %-20s | %-10s | %-15s |\n", "Product Name", "Company Name", "Variety", "Price", "Available");
		System.out.println("+---------------------------------------------------------------------------------------------------+");

		for (int i = 0; i < cl.size(); i++) {
		    Product a = cl.get(i);
		    System.out.printf("| %-20s | %-20s | %-20s | %-10.2f | %-15s |\n", a.getProduct_name(), a.getCompany_name(), a.getProduct_variety(), a.getPrice(), a.getProduct_Available());
		}

		System.out.println("+---------------------------------------------------------------------------------------------------+");
		System.out.println();
		
	}

	private void insert() throws SQLException 
	{
		System.out.println("Enter the product name           : ");
		sc.nextLine();
		String product = sc.nextLine();
		System.out.println("Enter the company name           : ");
		String company = sc.nextLine();
		System.out.println("Enter the specific variety name  : ");
		String variety = sc.nextLine();
		System.out.println("Enter the price details          : ");
		Double price = sc.nextDouble();
		System.out.println("Enter the available count        :  ");
		int available = sc.nextInt();
		Product p = new Product();
		p.setProduct_name(product);
		p.setCompany_name(company);
		p.setProduct_variety(variety);
		p.setPrice(price);
		p.setProduct_Available(available);
		Product s = new Product();
		s.insertProduct(p);
		
		
	}
	 
}
