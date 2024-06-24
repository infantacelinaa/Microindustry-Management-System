package controller;

import java.sql.SQLException;

import model.CompanyModel;
import model.ProductModel;
import java.util.*;
public class Product 
{
	ProductModel a = new ProductModel();
   private int id;
   private String product_name;
   private String Company_name;
   private String product_variety;
   private Double price;
   private int product_Available;
   public int getId() {
	   return id;
   }
   public void setId(int id) {
	   this.id = id;
   }
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCompany_name() {
		return Company_name;
	}
	public void setCompany_name(String company_name) {
		Company_name = company_name;
	}
	public String getProduct_variety() {
		return product_variety;
	}
	public void setProduct_variety(String product_variety) {
		this.product_variety = product_variety;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getProduct_Available() {
		return product_Available;
	}
	public void setProduct_Available(int product_Available) {
		this.product_Available = product_Available;
	}
	public void insertProduct(Product p) throws SQLException {
//		ProductModel obj = new ProductModel();
		a.insertProduct(p);
		
	}
	
	public void delete(Product p, String name) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String confirm = sc.next();
		a.deleteProduct(p,name,confirm);
		
	}
//	public void modify(Product p) {
////		ProductModel a = new ProductModel();
//		a.modify(p);
//	}
	public double selecteditems(ArrayList<Integer> items, ArrayList<Integer> quantity) throws SQLException {
		double x = a.selectedItems(items,quantity);
		return x;
	}
	public int modifyProduct(Product p) throws SQLException {
		
		int rows = a.locationChange(p);
		return rows;
	}
	public int modifyPrice(Product p) throws SQLException {
		int rows = a.priceChange(p);
		return rows;
	}
	public int modifyQuantity(Product p) throws SQLException {
		int rows = a.availableChange(p);
		return rows;
	}
	public int modifyVariety(Product p) throws SQLException {
		int rows = a.varietyChange(p);
		return rows;
	}

}
