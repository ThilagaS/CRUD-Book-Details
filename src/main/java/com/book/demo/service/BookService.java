package com.book.demo.service;

import java.util.List;

import com.book.demo.Book.Book;
import com.book.demo.Book.BookRequest;
import com.book.demo.Book.CheckOutResponse;
import com.book.demo.dao.BookDao;


public interface BookService {
		void saveBook(Book book);
		List<Book> getAllBook();		
		BookDao findBookById(String id); 
		BookDao deleteBookById(String id);	
		void updateBook(String id);
		CheckOutResponse checkOutBook(List<BookRequest> books);
		
}
