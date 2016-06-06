package com.bookStoreApp.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import com.bookStoreApp.domain.Books;
import com.bookStoreApp.domain.OrderDetails;
import com.bookStoreApp.domain.OrderGeneral;
import com.bookStoreApp.domain.Users;
import com.bookStoreApp.utils.SqlHelper;

public class OrderService {

	public String recOrderInfo(ShoppingCart sc, Users user){
		LinkedHashMap<Books, String> info = sc.cartInfo();
		
		OrderGeneral og = new OrderGeneral(user.getId(), sc.getCost());
		OrderDetails od = new OrderDetails(og.getOrderId(), info);
		
		// update order general table
		String ogSql = "insert into orderGeneral values (?,?,?,?)";
		Object[] ogParam = {og.getOrderId(), og.getUserId(), og.getTotalPrice(), new Date()};
		SqlHelper.executeUpdate(ogSql, ogParam);
		
		// update oder details table
		LinkedHashMap<String, Integer> items = od.getItems();
		
		for (String tmp:items.keySet()){
			String odSql = "insert into orderDetails (orderId, itemName, itemNum) values (?,?,?)";
			Object[] odParam = {od.getOrderId(), tmp, items.get(tmp)};
			System.out.println(od.getOrderId()+"-->"+tmp+"-->"+items.get(tmp));
			SqlHelper.executeUpdate(odSql, odParam);
		}
		
		return og.getOrderId();
	}
	
	public ArrayList<OrderGeneral> getOrderGeneral(Users user){
		ArrayList<OrderGeneral> list = new ArrayList<>();
		
		String sql = "select orderId, totalPrice, orderDate from orderGeneral where userId=?";
		Object[] parameter = {user.getId()};
		
		ResultSet rs = SqlHelper.executeQuery(sql, parameter);
	
		try {
			while (rs.next()) {
				OrderGeneral og = new OrderGeneral(rs.getString(1), rs.getDouble(2), (Date) rs.getObject(3));
				System.out.println(og);
				list.add(og);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		  SqlHelper.close(null, null, rs);	
		}
		
		return list;
	}
	
	public LinkedHashMap<String, Integer> getOrderDetails(String orderId){
		LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
		
		String sql = "select itemName, itemNum from orderDetails where orderId=?";
		Object[] parameter = {orderId};
		
		ResultSet rs = SqlHelper.executeQuery(sql, parameter);
		
		try {
			while (rs.next()) {
				list.put(rs.getString(1), rs.getInt(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			  SqlHelper.close(null, null, rs);	
			}
		
		return list;
	}
	
	
	public static void main(String[] args){
		OrderService os = new OrderService();
    	ShoppingCart sc = new ShoppingCart();
    	
    	Books book1 = new Books(1, "JSP application", 59.0);
    	Books book2 = new Books(2, "Java Web service", 45);
    	Books book3 = new Books(3, "Thinking in Java", 99);
    	
    	sc.addBooks(book1);
    	sc.addBooks(book1);
    	sc.addBooks(book1);
		
    	sc.addBooks(book2);
    	sc.addBooks(book2);
    	
    	sc.addBooks(book3);
    	
    	Users user1 = new Users(1, "aaaa1", "hahaxixihoho2016@gmail.com", 1);
    	
    //	os.recOrderInfo(sc, user1);
    	ArrayList<OrderGeneral> list = os.getOrderGeneral(user1);
    	
    	for(OrderGeneral og:list){
    		LinkedHashMap<String, Integer> details = os.getOrderDetails(og.getOrderId());
    		System.out.println(og.getOrderId()+"-->"+String.valueOf(details));
    	}
    	
    	System.out.println(String.valueOf(list));
	}
	
	
}
