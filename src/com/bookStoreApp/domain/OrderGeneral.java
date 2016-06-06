package com.bookStoreApp.domain;

import java.util.Date;
import java.util.Random;

public class OrderGeneral {

	private String orderId = createOrderID();
	private int userId;
	private double totalPrice;
	private Date orderDate = new Date();
	
	public OrderGeneral(String orderId, double totalPrice, Date orderDate) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	
	
	public OrderGeneral(int userId, double totalPrice) {
		super();
		this.userId = userId;
		this.totalPrice = totalPrice;
	}

	// generate random orderID
	private String createOrderID(){
		
	   Random r = new Random();
	   String orderId = r.nextInt(9999999) + "";
	   StringBuffer sb = new StringBuffer();
	   for (int i=0; i<7-orderId.length(); i++){
		   sb.append("0");
	   }
	   orderId = sb.toString()+orderId;
	   
		return orderId;
	}
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

    @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.orderId+"-->"+this.userId+"-->"+this.totalPrice+"-->"+this.orderDate;
	}

	public static void main(String[] args){
    	OrderGeneral order1 = new OrderGeneral(1, 100.00);
    	OrderGeneral order2 = new OrderGeneral(2, 210.12);
    	
    	System.out.println(order1);
    	System.out.println(order2);
    }
	
	
}
