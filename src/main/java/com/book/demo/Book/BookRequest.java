package com.book.demo.Book;

import org.springframework.stereotype.Component;

@Component
public class BookRequest {
	private String id;
	private String name;
	private String author;
	private String description;
	private String type;
	private Double price;
	public BookRequest() {
		
		// TODO Auto-generated constructor stub
	}

	
	
	public BookRequest(String id, String name, String author, String description, String type, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
		this.type = type;
		this.price = price;
	}





	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	} 
	
}
