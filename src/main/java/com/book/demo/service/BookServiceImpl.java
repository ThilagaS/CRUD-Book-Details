package com.book.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.Book.Book;
import com.book.demo.Book.BookRequest;
import com.book.demo.Book.CheckOutResponse;
import com.book.demo.BookRepository.BookRepository;
import com.book.demo.BookRepository.DiscountRepository;
import com.book.demo.dao.BookDao;
import com.book.demo.dao.DiscountDao;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j 
public class BookServiceImpl  implements BookService{
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	BookRepository bookRespository;
	@Autowired
	DiscountRepository discountRepository;
	
	
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
		log.info("Book Saved Successfully");
	}
	
	@Override
	public List<Book> getAllBook(){
		List<BookDao> bookDao=bookRespository.findAll();
		return bookDao.stream().map(bookDetails->new Book(bookDetails.getId(),bookDetails.getName(),bookDetails.getAuthor(),bookDetails.getDescription(),bookDetails.getType(),bookDetails.getPrice())).collect(Collectors.toList());
	}
	
	
	@Override
	public BookDao findBookById(String bookId) {
		BookDao bookDao=bookRespository.findBookById(bookId);
	
		return bookDao;
	}
	
	public BookDao deleteBookById(String id) {
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

	@Override
	public CheckOutResponse checkOutBook(List<BookRequest> books) {
		CheckOutResponse response=new CheckOutResponse();
		double discountprice=0;

		        for(BookRequest bookReq:books) {
		    	DiscountDao discount= discountRepository.getDiscountByType(bookReq.getType());
		    	 discountprice=((bookReq.getPrice()*discount.getDiscount())/100);
		    	response.setTotalprice(bookReq.getPrice()-discountprice);
		        }
		    
		   log.info("checkout response");
		return response;
		
	}

}
