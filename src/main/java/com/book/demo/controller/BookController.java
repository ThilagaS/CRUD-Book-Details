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
import com.book.demo.dao.BookDao;
import com.book.demo.service.BookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BookController {

	@Autowired
	BookService bookService;

	@Operation(summary = "This is to Create new Book")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Book Details", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Page not found", content = @Content) })
	@PostMapping("/v1/management/book")
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {

		bookService.saveBook(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);

	}


	@Operation(summary = "This is to get all books")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Book Details", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Page not found", content = @Content) })

	@GetMapping("/v1/management/book")
	public List<Book> findAll() {
		return bookService.getAllBook();
	}


	@Operation(summary = "This is to get specific book id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Book Details", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Page not found", content = @Content) })
    @GetMapping("/v1/management/book/{id}")
	public ResponseEntity<BookDao> getBookById(@PathVariable("id") String id) {
		return new ResponseEntity<BookDao>(bookService.findBookById(id), HttpStatus.OK);
	}


	@Operation(summary = "This is to checkout book")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Book Details", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Page not found", content = @Content) })

	
	@GetMapping("/v1/management/book/checkout")
	public ResponseEntity<CheckOutResponse> checkout(@RequestBody List<BookRequest> bookRequest) {
		return new ResponseEntity<CheckOutResponse>(bookService.checkOutBook(bookRequest), HttpStatus.OK);
	}

	@Operation(summary = "This is to delete  Book")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Details of All the Participants", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Page not found", content = @Content) })

	@DeleteMapping("/v1/management/book/{id}")
	public ResponseEntity<BookDao> deleteBook(@PathVariable("id") String id) {
		bookService.deleteBookById(id);
		return new ResponseEntity<BookDao>(HttpStatus.NO_CONTENT);
	}

	@Operation(summary = "This is to update  Book")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Book Details", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Page not found", content = @Content) })

	@PutMapping("/v1/management/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") String id) {
		bookService.updateBook(id);
		return new ResponseEntity<Book>(HttpStatus.ACCEPTED);
	}

}
