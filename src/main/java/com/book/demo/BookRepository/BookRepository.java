package com.book.demo.BookRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.book.demo.dao.BookDao;

public interface BookRepository extends MongoRepository<BookDao,String> {
	BookDao findBookBybookId(String id);

}
