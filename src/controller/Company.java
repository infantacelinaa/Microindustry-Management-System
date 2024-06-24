package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.CompanyModel;
import view.CompanyView;
public class Company 
{
	  private int id;
	  private String username;
	  private String email_id;
	  private String pass_word;
	  private String company;
	  private String details;
	  private String usb;
	  private String contact;
	  private String location;
	  public Company() {
		  
	  }
	  public Company(String username,String email_id,String pass_word,String company,String details,String usb,String contact,String location)
	  {
		  this.username = username;
		  this.email_id = email_id;
		  this.pass_word = pass_word;
		  this.company = company;
		  this.details = details;
		  this.usb = usb;
		  this.contact = contact;
		  this.location = location;
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
	  
	  public String getCompany()
	  {
		  return company;
	  }
	  
	  public void setCompany(String company)
	  {
		  this.company = company;
	  }
	  
	  public String getDetails()
	  {
		  return details;
	  }
	  
	  public void setDetails(String details)
	  {
		  this.details = details;
	  }
	  
	  public String getUsb()
	  {
		  return usb;
	  }
	  
	  public void setUsb(String usb)
	  {
		  this.usb = usb;
	  }
	  
	  public String getContact()
	  {
		  return contact;
	  }
	  
	  public void setContact(String contact)
	  {
		  this.contact = contact;
	  }
	  
	  public String getLocation()
	  {
		  return location;
	  }
	  
	  public void setLocation(String location)
	  {
		  this.location = location;
	  }
	  
	public void setCompanyDetails(Company c) throws SQLException {
		CompanyModel m = new CompanyModel();
		m.RegisterCompany(c);
	}
	
	
	public Company loginCompany(Company c) throws SQLException {
		CompanyModel m = new CompanyModel();
		Company x = m.loginCompany(c);
		return x;
	}
	public int idCheck(String name) throws SQLException {
		CompanyModel n = new CompanyModel();
		int id = n.idCheck(name);
		return id;
	}
	public ArrayList<Product> idTodelete(String name) throws SQLException {
		CompanyModel g = new CompanyModel();
		ArrayList<Product> bl = g.getIdValue(name);
		return bl;
	}
	public ArrayList<Company> data(int c_id) throws SQLException {
		CompanyModel m = new CompanyModel();
		ArrayList<Company> company = m.data(c_id);
		return company;
	}
	public int modify(Company p) throws SQLException {
		CompanyModel m = new CompanyModel();
		int rows = m.passwordChange(p);
		return rows;
	}
	public int modifyUsb(Company p) throws SQLException {
		CompanyModel m = new CompanyModel();
		int rows = m.usbChange(p);
		return rows;
		
	}
	public int modifyLocation(Company p) throws SQLException {
		CompanyModel m = new CompanyModel();
		int rows = m.locationChange(p);
		return rows;
		
	}
	public int modifyContact(Company p) throws SQLException {
		CompanyModel m = new CompanyModel();
		int rows = m.contactChange(p);
		return rows;
	}
	
	
	  

}
