package com.bookStoreApp.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookStoreApp.domain.Users;
import com.bookStoreApp.utils.SqlHelper;

public class UserService {

	// verify user
	public Users checkUser(Users user){
		String sql = "select * from users where username=? and password=?";
		String[] parameter = {user.getUsername(), user.getPassword()};
		System.out.println(user.getUsername()+":"+user.getPassword());
		ResultSet rs = SqlHelper.executeQuery(sql, parameter);
		try {
			rs.next();
			int id = rs.getInt(1);
			String username = rs.getString(2);
			String email = rs.getString(3);
			int grade = rs.getInt(4);	
			
			Users loginUser = new Users(id, username, email, grade);
			System.out.println("user created:"+loginUser);
			return loginUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(null, null, rs);
		}
				
		return null;
	}
}
