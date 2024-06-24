package controller;

public class Order 
{
   private int order_id;
   private String order_date;
   private int Customer_id;
   private double price;
   private int quantity;
   private String status;
   public int getQuantity() {
	return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
   
   public int getOrder_id() {
	return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	   
}
