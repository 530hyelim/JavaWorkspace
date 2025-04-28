package com.kh.chap01_oneVsmany.model.vo;

public class Book {
	private String title;
	private String author;
	private int price;
	private String publisher;
	
	public Book() {
		
	}
	public Book(String title, String author, int price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}
	
	//각 필드에 대한 setter 메서드들 생성
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	//각 필드에 대한 getter 메서드들 생성
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	
	//alt + shift + S => to generate getter/setter methods
	
	//현재 객체의 내부 데이터를 문자열로 합쳐서 반환하는 메서드
	public String information() {
		return title+", "+author+", "+"price"+", "+publisher;
	}
}
