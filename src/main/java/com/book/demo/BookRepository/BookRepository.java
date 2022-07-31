package com.book.demo.BookRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book.demo.dao.BookDao;
@Repository
public interface BookRepository extends MongoRepository<BookDao,String> {
	BookDao findBookById(String id);

}
