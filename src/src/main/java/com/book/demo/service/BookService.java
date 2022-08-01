package com.book.demo.service;

import java.util.List;

import com.book.demo.Book.Book;
import com.book.demo.Book.BookRequest;
import com.book.demo.Book.CheckOutResponse;


public interface BookService {
		void saveBook(Book book);
		List<Book> getAllBook();		
		Book findBookById(String id); 
		Book deleteBookById(String id);	
		void updateBook(String id);
		CheckOutResponse checkOutBook(List<BookRequest> books);
		
}
