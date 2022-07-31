package com.book.demo.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class BookDao{

	private String id;
	private String name;
	private String author;
	private String description;
	private String type;
	private double price; 
	
}
