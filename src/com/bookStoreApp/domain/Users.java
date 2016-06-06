package com.bookStoreApp.domain;

public class Users {

	private int id;
	private String username;
	private String email;
	private int grade;
	private String password;
	
	public Users(int id, String username, String email, int grade,
			String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.grade = grade;
		this.password = password;
	}

	public Users() {
		super();
	}

	public Users(int id2, String username2, String email2, int grade2) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id2;
		this.username = username2;
		this.email = email2;
		this.grade = grade2;
	}

	public Users(String username2, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.username = username2;
		this.password = password;

	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId()+"-->"+this.getUsername()+"-->"+this.getEmail()+"-->"+this.getGrade()+"-->"+this.getPassword();
	}
	
	
	
	
	
	
	
}
