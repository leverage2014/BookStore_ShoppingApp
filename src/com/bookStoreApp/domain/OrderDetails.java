package com.bookStoreApp.domain;

import java.util.LinkedHashMap;

public class OrderDetails {

	private int id;
	private String orderId;
	private LinkedHashMap<String, Integer> items = new LinkedHashMap<>();
	
	
	public OrderDetails(String orderId, LinkedHashMap<Books, String> info) {
		super();
		this.orderId = orderId;
		
		for (Books one:info.keySet()){
			this.items.put(one.getTitle(), Integer.parseInt(info.get(one)));
			System.out.println(one.getTitle()+"-->"+Integer.parseInt(info.get(one)));
		}
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LinkedHashMap<String, Integer> getItems() {
		return items;
	}




	public void setItems(LinkedHashMap<String, Integer> items) {
		this.items = items;
	}




	public void addItem(Books book, int num){
		items.put(book.getTitle(), num);
	}
	
	
}
