package com.book.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.Book.Book;
import com.book.demo.BookRepository.BookRepository;
import com.book.demo.dao.BookDao;
@Service
public class BookServiceImpl  implements BookService{

	@Autowired
	BookRepository bookRespository;
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	Book book;
	public void saveBook(Book book) {
		bookDao.setId(book.getId());
		bookDao.setName(book.getName());
		bookDao.setAuthor(book.getAuthor());
		bookDao.setDescription(book.getDescription());
		bookDao.setType(book.getType());
		bookDao.setPrice(book.getPrice());
		bookRespository.save(bookDao);
	}
	
	@Override
	public List<Book> getAllBook(){
		List<BookDao> bookDao=bookRespository.findAll();
		return bookDao.stream().map(bookDetails->new Book(bookDetails.getId(),bookDetails.getName(),bookDetails.getAuthor(),bookDetails.getDescription(),bookDetails.getType(),bookDetails.getPrice())).collect(Collectors.toList());
	}
	
	
	@Override
	public Book findBookById(String bookId) {
		BookDao bookDao=bookRespository.findBookById(bookId);
		book.setId(bookDao.getId());
		book.setName(bookDao.getName());
		book.setAuthor(bookDao.getAuthor());
		book.setDescription(bookDao.getDescription());
		book.setType(bookDao.getType());
		book.setPrice(bookDao.getPrice());
		 book.setAuthor(bookDao.getAuthor());
		return book;
	}
	
	public Book deleteBookById(String id) {
		bookRespository.deleteById(id);
		 return null;
	}

	@Override
	public void updateBook(String id) {
		BookDao bookDao=bookRespository.findBookById(id);

		bookDao.setName(book.getName());
		bookDao.setAuthor(book.getAuthor());
		bookDao.setDescription(book.getDescription());
		bookDao.setType(book.getType());
		bookDao.setPrice(book.getPrice());
		bookRespository.save(bookDao)	;
	}

}
