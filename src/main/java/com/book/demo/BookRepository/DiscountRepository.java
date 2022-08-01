package com.book.demo.BookRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book.demo.dao.BookDao;
import com.book.demo.dao.DiscountDao;
@Repository
public interface DiscountRepository extends MongoRepository<DiscountDao,String> {
	DiscountDao getDiscountByType(String type);

}
