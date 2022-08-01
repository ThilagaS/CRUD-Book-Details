package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.demo.Book.Book;
import com.book.demo.BookRepository.BookRepository;
import com.book.demo.dao.BookDao;
import com.book.demo.service.BookServiceImpl;

@SpringBootTest
public class BookServiceTest {

    private static final String ID = "1";
    private static final String NAME = "Science";
    private static final String AUTHOR = "Mark";   
    private static final String DESCRIPION = "Science book";
    private static final String TYPE = "Friction";
    private static final Double price = 200d;


    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    @Mock
    private BookRepository bookRepositoryMock;

    @Test
    public void findAllBooks() {
        
    	BookDao book = bookDetails();
        List<BookDao>books = Collections.singletonList(book);
        when(bookRepositoryMock.findAll()).thenReturn(books);
        assertEquals(book, bookServiceImpl.getAllBook().get(0));
    }

    @Test
    public void findBookById() {
       
    	BookDao book = bookDetails();
        when(bookRepositoryMock.findById(ID)).thenReturn(Optional.of(book));
        assertEquals(book, bookServiceImpl.findBookById(ID));
    }

    @Test
    public void nullcheck() {
    
        when(bookRepositoryMock.findById(ID)).thenReturn(Optional.empty());
        
        assertNull(bookServiceImpl.findBookById(ID));
    }

    @Test
    public void savBook() {
       
    	Book book =bookRequest();
    	book.setId("2");
     	BookDao bookdao = bookDetails();
        when(bookRepositoryMock.save(bookdao)).thenReturn(bookdao);
     
      
    }

    @Test
    public void nullSaveBook() {
    	BookDao bookdao = bookDetails();
        when(bookRepositoryMock.save(bookdao)).thenReturn(bookdao);
        Book book=bookRequest();
    }

    @Test
    public void update_Book() {
       
    	BookDao bok = bookDetails();
        when(bookRepositoryMock.findById(bok.getId())).thenReturn(Optional.of(bok));
        when(bookRepositoryMock.save(bok)).thenReturn(bok);
        
    }

    @Test
    public void nullupdateBook() {
       

    	BookDao bok = bookDetails();
        when(bookRepositoryMock.findById(bok.getId())).thenReturn(Optional.of(bok));
        when(bookRepositoryMock.save(bok)).thenReturn(bok);

    }

    @Test
    public void deleteBookby_d() {
       
    	BookDao book = bookDetails();
        when(bookRepositoryMock.findById(book.getId())).thenReturn(Optional.of(book));
        //When
        doNothing().when(bookRepositoryMock).deleteById(ID);
        //Then
        assertEquals(book, bookServiceImpl.deleteBookById(ID));
    }

    @Test
    public void returnnull() {
    	BookDao book = bookDetails();
        when(bookRepositoryMock.findById(book.getId())).thenReturn(Optional.of(book));
        //When
        doNothing().when(bookRepositoryMock).deleteById(ID);
        //Then
    
        //Then
        assertNull(bookServiceImpl.deleteBookById(ID));
    }

    private BookDao bookDetails() {
    	BookDao book = new BookDao();
    	book.setId(ID);
    	book.setName(NAME);
    	book.setAuthor(AUTHOR);
    	book.setDescription(DESCRIPION);
    	book.setType(TYPE);
    	book.setPrice(price);
    	book.setName(NAME);
        return book;
    }
    
    private Book bookRequest() {
    	Book book = new Book();
    	book.setId(ID);
    	book.setName(NAME);
    	book.setAuthor(AUTHOR);
    	book.setDescription(DESCRIPION);
    	book.setType(TYPE);
    	book.setPrice(price);
    	book.setName(NAME);
        return book;
    }
}
