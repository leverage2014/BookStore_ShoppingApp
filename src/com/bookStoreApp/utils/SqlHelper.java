package com.bookStoreApp.utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SqlHelper {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	
	// read properties docs
	private static Properties pp = null;
	//private static FileInputStream fis = null;
	private static InputStream is = null;
	
	static{
		try{
			System.out.println("creating!");
			pp = new Properties();
		//	fis = new FileInputStream("/Users/yx/Documents/workspace/UserManagerApp02/src/dbinfo.properties");
		
			//使用java web，需要使用类加载器
			is = SqlHelper.class.getClassLoader().getResourceAsStream("db.properties");
			
			//pp.load(fis);
			pp.load(is);
		
			url = pp.getProperty("url");
			username = pp.getProperty("username");
			password = pp.getProperty("password");
			driver = pp.getProperty("driver");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
	        if(con != null) {
	            System.out.println("Connected to DB!!");
	          }
	        
	        System.out.println("finish");
	     } catch (Exception e){
	    
	    	 e.printStackTrace();
	    }
	}
	
	public static ResultSet executeQuery(String sql, Object[] parameter){
		ResultSet tmpRs = null;
		
		try {
			ps = con.prepareStatement(sql);
		    if(parameter!=null || parameter.length!=0){
			for(int i=0; i<parameter.length; i++){
				ps.setObject(i+1, parameter[i]);
			}
		}		
		    tmpRs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tmpRs;
	}
	
	public static int executeUpdate(String sql, Object[] parameter){
		int affected = 0;
		
		try {
			ps = con.prepareStatement(sql);
		    if(parameter!=null || parameter.length!=0){
			for(int i=0; i<parameter.length; i++){
				ps.setObject(i+1, parameter[i]);
			}
		}		
		    affected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return affected;
	}
	
	public static void close(PreparedStatement ps, Connection con, ResultSet rs){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		SqlHelper.con = con;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

	public static void setPs(PreparedStatement ps) {
		SqlHelper.ps = ps;
	}

	public static void main(String[] args) throws Exception{
		String[] para = {};
		ResultSet rs = SqlHelper.executeQuery("select * from users", para);
		
        while(rs.next()){
        	System.out.println("id: " + rs.getObject(1));    
        	System.out.println("username: " + rs.getObject(2));    
        	System.out.println("email: " + rs.getObject(3));    
        	System.out.println("grade: " + rs.getObject(4));
        	System.out.println("=============");
        } 
	}
	
}
