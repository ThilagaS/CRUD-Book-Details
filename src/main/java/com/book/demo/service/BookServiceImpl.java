package com.book.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.Book.Book;
import com.book.demo.BookRepository.BookRepository;
@Service
public class BookServiceImpl  implements BookService{

	@Autowired
	BookRepository bookRespository;
	
	public void saveBook(Book book) {
		Book book
		bookRespository.save(book);
	}
	
	@Override
	public List<Book> getAllBook(){
		return bookRespository.findAll();
	}
	
	
	@Override
	public Book findBookById(String id) {
		return bookRespository.findBookBybookId(id);
	}
	
	public Book deleteBookById(String id) {
		bookRespository.deleteById(id);
		 return null;
	}

	@Override
	public void updateBook(Book book) {
		bookRespository.save(book);		
	}

}
