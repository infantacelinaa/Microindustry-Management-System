package view;
import java.sql.SQLException;
import java.util.*;
import model.ProductModel;
import controller.Company;
import controller.Order;
import controller.Product;
import controller.User;
import controller.order_items;
public class UserView {
	
    Scanner sc = new Scanner(System.in);
	public void display() throws SQLException {
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
		    	loginUser();
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
				System.out.println("Enter the Permanent_Address: ");
				sc.nextLine();
				String address = sc.nextLine();
				System.out.println("Enter the Contact: ");
				String contact = sc.next();
				User al = new User();
				User a = new User();
				a.setUsername(username);
				a.setEmail(email_id);
				a.setPassword(pass_word);
				a.setAddress(address);
				a.setContact(contact);
				al.setRegisterDetail(a);
				loginUser();
		    	break;
		    }
		    case 3:
		    {
		    	break;
		    }
		}
	}
	private void loginUser() throws SQLException {
		System.out.println("Enter the valid email id: ");
		String email_id = sc.next();
		System.out.println("Enter the password: ");
		String pass_word = sc.next();
		User u = new User();
		u.setEmail(email_id);
		u.setPassword(pass_word);
		User n = new User();
		User m = new User();
		int id = m.getUserId(email_id);
		User w = n.checkLogin(u);
		if(w!=null && u.getPassword().equals(w.getPassword()))
		{
			System.out.println("Login Successfully!!");
			displayUser(id);
		}
		else
		{
			System.out.println("Login failed");
		}
		
	}
	private void displayUser(int id) throws SQLException {
		System.out.println("______________________________________________");
	   	System.out.println("__We Gladly welcome to this expo ,enjoy it!!__");
	   	System.out.println("______________________________________________");
	   	System.out.println();
	   	System.out.println("             +------------------------+           ");
	   	System.out.println("             |The Customer id : "+id+"     |"           );
	   	System.out.println("             +------------------------+           ");
	   	System.out.println();
	   	userDisplay();
	   	System.out.println();
	   	System.out.println("  To find additional informations about a industry     ");
	   	System.out.println("  Enter a company id for further information.          ");
	   	System.out.println("  **To proceed click 'yes' else click 'no'**           ");
	   	String option = sc.next();
	   	sc.nextLine();
	   	if(option.equalsIgnoreCase("yes"))
	   	{
	   	System.out.println("Enter the company id: ");
	   	int c_id = sc.nextInt();
	   	data(c_id);
	   	}
	   	System.out.println();
		System.out.println();
	    System.out.println("~~~~~~~~~~~ 	if you like to try our products, ~~~~~~~~~~~~");
	    System.out.println(" ~~~~~~~~~~~~~~~~~~~~  BUY IT AND ENJOY IT   ~~~~~~~~~~~~~~~~ ");
	    System.out.println("if you like to buy then enter 'yes' else 'no' ");
	    String choose = sc.next();
	    if(choose.equalsIgnoreCase("yes"))
	    {
	    	System.out.println("Select the products by its unique id");
	    	System.out.println();
	    	ArrayList<Integer> items = new ArrayList<>();
	    	ArrayList<Integer> quantity = new ArrayList<>();//
	    	System.out.println("How many products have you choosen to buy ? ");
	    	int count = sc.nextInt();
	    	System.out.println("Enter the id values to proceed");
	    	for(int i=0;i<count;i++)
	    	{
	    		items.add(sc.nextInt());
	    		
	    	}
	    	System.out.println("Enter the quantity required for each product : ");//
	    	for(int i=0;i<count;i++)
	    	{
	    		quantity.add(sc.nextInt());//
	    	}
	    	User h = new User();
	    	int noOfQuantity = h.calculate(quantity);
	    	System.out.println(noOfQuantity);
	    	System.out.println("     THE PRODUCTS IN THE CART   ");
	    	System.out.println();
	    	Product d = new Product();
	    	double total = d.selecteditems(items,quantity);
	    	System.out.println("The total price :  "+total);
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("Enter the option to confirm");
	    	System.out.println("+---------------------------------------------------------+");
	    	System.out.println("|         Enter 1 - confirm to proceed for payment         |");
	    	System.out.println("|         Enter 2 - not confirmed                          |");
	    	System.out.println("|         Enter 3 - not interested to buy                  |");
	    	System.out.println("+---------------------------------------------------------+");
	    	int confirm = sc.nextInt();
	    	switch(confirm)
	    	{
	    	     case 1:
	    	     {
	    	    	displayPayment(total,items,id,noOfQuantity,quantity);
	    	    	break;
	    	     }
	    	     case 2:
	    	     {
	    	    	 displayUser(id);
	    	    	 break;
	    	     }
	    	     case 3:
	    	     {
	    	    	 loginUser();
	    	    	 break;
	    	     }
	    	     default:
	    	    	 System.out.println("Enter a valid option");
	    	}
	    }
	    System.out.println("We hope you enjoyed your experience. Come again!");
	    
		
	}
	private void displayPayment(double total, ArrayList<Integer> items, int id, int noOfQuantity, ArrayList<Integer> quantity) throws SQLException 
	{
		System.out.println("The total price is : "+total);
		System.out.println("Enter the amount:    ");
		double amount = sc.nextDouble();
		if(amount == total)
		{
			System.out.println("Your payment is successful");
			User v = new User();
			v.orderBill(id,total,noOfQuantity);
			ArrayList<Order> al = v.updateQuantity(items,id,total,quantity);
			int order_id = v.retrieveId(id);
			int rows = v.menu(items,id,quantity,order_id);
			ArrayList<order_items> bl = v.displayMenu(order_id);
			System.out.println();
			System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
			System.out.printf("| %-8s | %-20s | %-15s | %-15s | %-20s | %-30s |\n", "Order ID", "Order Date", "Customer ID","Quantity", "Price","Status");
			System.out.println("+-------------------------------------------------------------------------------------------------------------------+");

			for (Order o : al) {
			    System.out.printf("| %-8d | %-20s | %-15d | %-15d | %-20.2f | %-30s |\n",
			                      o.getOrder_id(),
			                      o.getOrder_date(),
			                      o.getCustomer_id(),
			                      o.getQuantity(),
			                      o.getPrice(),
			                      o.getStatus());
			    
			    System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
			}
            
			System.out.println("-----------------------------------------------------------------");
			System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Item ID", "Order ID", "Product ID", "Quantity", "Price");
			System.out.println("-----------------------------------------------------------------");
			for (order_items o : bl) {
			    System.out.printf("| %-10d | %-10d | %-10d | %-10d | %-10.2f |\n", o.getItem_id(), o.getOrder_id(), o.getProduct_id(), o.getQuantity(), o.getPrice());
			}
			System.out.println("-----------------------------------------------------------------");

			

			
		}
		else
		{
			System.out.println("The payment is not successful");
			if(amount<total)
			{
				System.out.println("Your balance is insufficient");
			}
		}
		
	}
	private void data(int c_id) throws SQLException {
		Company c = new Company();
		ArrayList<Company> al = c.data(c_id);
	    for (int i=0;i<al.size();i++) {
	      Company company = al.get(i);
//	      System.out.println("-----------------------------------------------");
	      System.out.println("        The  Company name      :" +company.getCompany());
	      System.out.println("        The  Company details   :" +company.getDetails());
	      System.out.println("        The  Company Usb       :" +company.getUsb());
	      System.out.println("        The  Contact           :" +company.getContact());
	      System.out.println("        The  Location          :" +company.getLocation());
//	      System.out.println("-----------------------------------------------");
	    }
	    
	    System.out.println("     +-----------------------------------------------------------------------+");
	}
	
	public void userDisplay() throws SQLException 
	{
		User m = new User();
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
	
	
	
     
}
