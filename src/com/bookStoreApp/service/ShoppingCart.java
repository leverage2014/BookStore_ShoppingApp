package com.bookStoreApp.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.bookStoreApp.domain.Books;

public class ShoppingCart {

	private LinkedHashMap<String, Books> books = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> prices = new LinkedHashMap<>();
   // public static ShoppingCart cart = new ShoppingCart();
	
	private double cost;
	
    public ShoppingCart(){
    	
    }	
    
  //  public static ShoppingCart getCart(){
  //  	return cart;
   // }
    
    public double getCost(){
    	return this.cost;
    }
    
    public double updateCost(LinkedHashMap<String, Integer> prices, LinkedHashMap<String, Books> books){
    	double total = 0.0;
    	if(prices != null){
    		for (String one : books.keySet()){
    			total += books.get(one).getPrice() * prices.get(one);
    		}
    	}
    	
    	return total;
    }
	
    public void addBooks(Books book){
    	int bookId = book.getId();
    	String id = String.valueOf(bookId);
    	
    	if(prices.containsKey(id)){
    		int newNum = prices.get(id);
    		prices.put(id, newNum+1);
    	} else {
    		books.put(id, book);
    		prices.put(id, 1);
    	}
    	
    	this.cost = updateCost(prices, books);
    }
    
    public void updateBooks(int num2buy, Books book){
    	System.out.println("update");
    	if(num2buy <= 0){
    		System.out.println("update1");
    	   books.remove(String.valueOf(book.getId()));
    	   prices.remove(String.valueOf(book.getId()));
    	   System.out.println("update2");
    	} else {
    		prices.put(String.valueOf(book.getId()), num2buy);
    	}
    	
    	this.cost = updateCost(prices, books);
    }
    
    public LinkedHashMap<Books, String> cartInfo(){
    	LinkedHashMap<Books, String> info = new LinkedHashMap<Books, String>();
    	
    	for (String one:books.keySet()){
    		info.put(books.get(one), String.valueOf(prices.get(one)));
    	}
    	
    	return info;
    }

    public void deleteBooks(Books book){
    	updateBooks(-1, book);
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		ArrayList<String> display = new ArrayList<>();
		
		if(prices != null && books != null){
			for(String one:books.keySet()){
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				sb.append(books.get(one).getTitle());
				sb.append(",");
				sb.append(prices.get(one));
				sb.append("]");
				display.add(sb.toString());
			}
		}
		
		return String.valueOf(display)+"--> total:"+this.cost;
	}
    
    public static void main(String[] args){
    	ShoppingCart sc = new ShoppingCart();
   // 	ShoppingCart sc2 = ShoppingCart.getCart();
    	
    	Books book1 = new Books(1, "JSP application", 59.0);
    //	Books book2 = new Books(2, "Java Web service", 45);
    //	Books book3 = new Books(3, "Thinking in Java", 99);
    	
    	sc.addBooks(book1);
    	sc.addBooks(book1);
    	sc.addBooks(book1);

    	System.out.println(sc);
    	
    	sc.updateBooks(0, book1);
    	System.out.println(sc);
    	
 

    	
    	
    }
    
	
}
