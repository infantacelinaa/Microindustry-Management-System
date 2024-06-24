package view;
import java.sql.SQLException;
import java.util.*;
import controller.*;
public class Main 
{
	public static void main(String[] args) throws SQLException
	{
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while(b)
        {
		System.out.println("....Welcome to Small Scale Expo!!...");
		System.out.println();
		System.out.println(" ---------------------------------- ");
    	System.out.println("|  Enter '1' for User              |");
    	System.out.println("|  Enter '2' for Company           |");
    	System.out.println("|  Enter '3' for Admin             |");
    	System.out.println("|  Enter '4' for Exit              |");
    	System.out.println(" ---------------------------------- ");
    	System.out.println("Are you a new client? then register");
		System.out.println("else Login!!");
		System.out.println();
        int choice = sc.nextInt();
        switch(choice)
        {	
            case 1:
            {
        	UserView u = new UserView();
        	u.display();
        	break;
            }
            case 2:
            {
             CompanyView c = new CompanyView();
             c.display();
             break;
            }
            case 3:
            {
             AdminView a = new AdminView();
             a.display();
             break;
            }
            case 4:
            {
            	b = false;
            	break;
            }
            default:
            	System.out.println("Enter a valid option");
        }

    	
	    }
	}
   
}
