package com.bookStoreApp.domain;

public class Books {
	
	private int id;
	private String title;
	private double price;
	private String press;
	private int nums;
    //private int num2buy;
	
	
	
	public Books(int id, String title, double price, String press) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.press = press;
	}
	
	public Books(int id, String title, double price, String press, int nums) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.press = press;
		this.nums = nums;
	}
	
	public Books(int id, String title, double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public Books() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId()+"-->"+this.getTitle()+"-->"+this.getPrice()+"-->"+this.getPress()+"-->"+this.getNums();
	}
	
	

}
