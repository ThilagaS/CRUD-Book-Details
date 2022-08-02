package com.book.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.Book.Book;
import com.book.demo.Book.BookRequest;
import com.book.demo.Book.CheckOutResponse;
import com.book.demo.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/management/book")
	public HttpStatus createBook(@Valid @RequestBody Book book) {
		
		bookService.saveBook(book);
		return HttpStatus.CREATED;

	}

	@GetMapping("/management/book")
	public List<Book> findAll() {
		return bookService.getAllBook();
	}

	@GetMapping("/management/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") String id){
		return new ResponseEntity<Book>(bookService.findBookById(id), HttpStatus.OK);
	}
	
	@GetMapping("/management/checkOut")
	public ResponseEntity<CheckOutResponse> checkout(@RequestBody List<BookRequest> bookRequest) {
		return new ResponseEntity<CheckOutResponse>(bookService.checkOutBook(bookRequest), HttpStatus.OK);
 	}
	
	@DeleteMapping("/management/book/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") String id) {
		bookService.deleteBookById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/management/book")
	public ResponseEntity<Book> updateBook(@PathVariable("id") String id) {
		bookService.updateBook(id);
		return new ResponseEntity<Book>(HttpStatus.ACCEPTED);
	}
	
}
