package com.bookStoreApp.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.bookStoreApp.domain.Books;
import com.bookStoreApp.utils.SqlHelper;

public class BookService {

	public ArrayList<Books> getAllBook(){
		ArrayList<Books> list = new ArrayList<>();
		
		String sql = "select * from bookMall";
		String[] parameter = {};
		ResultSet rs = SqlHelper.executeQuery(sql, parameter);
		System.out.println("enter getAllbooks");
		
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				double price = rs.getDouble(3);
				String press = rs.getString(4);
				int nums = rs.getInt(5);

				list.add(new Books(id, title, price, press, nums));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			SqlHelper.close(null, null, rs);
		}
		return list;
	}
	
}
