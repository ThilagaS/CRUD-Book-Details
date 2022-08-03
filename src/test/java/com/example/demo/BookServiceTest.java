package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.demo.Book.Book;
import com.book.demo.BookRepository.BookRepository;
import com.book.demo.dao.BookDao;
import com.book.demo.service.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	private static final String ID = "1";
	private static final String NAME = "Science";
	private static final String AUTHOR = "Mark";
	private static final String DESCRIPION = "Science book";
	private static final String TYPE = "Friction";
	private static final Double price = 200d;

	@Mock
	private BookRepository bookRepositoryMock;
	@InjectMocks
	private BookServiceImpl bookServiceImpl;

	@Mock
	List<BookDao> bookDao;

	@Test
	public void findAllBooks() {
		// Given
		when(bookRepositoryMock.findAll()).thenReturn(Arrays.asList(new BookDao()));
		// When
		List<Book> bookList = bookServiceImpl.getAllBook();

		// Then
		assertFalse(bookList.isEmpty());
		verify(bookRepositoryMock, times(1)).findAll();
	}

	@Test
	public void findBookById() {
		when(bookRepositoryMock.findBookById("1")).thenReturn(new BookDao());
		// When
		BookDao books = bookServiceImpl.findBookById("1");

		// Then
		assertEquals(books, bookServiceImpl.findBookById(ID));
	}

	@Test
	public void savBook() {

		BookDao book = bookDao();

		// providing knowledge
		when(bookRepositoryMock.save(any(BookDao.class))).thenReturn(book);

		BookDao bookdaoMock = bookRepositoryMock.save(book);
		assertThat(bookdaoMock.getAuthor()).isNotNull();

	}

	@Test
	public void nullSaveBook() {
		BookDao book = bookDao();

		when(bookRepositoryMock.save(any(BookDao.class))).thenReturn(new BookDao());
		BookDao bookdaoMock = bookRepositoryMock.save(book);
		assertThat(bookdaoMock.getAuthor()).isNull();

	}

	@Test
	public void update_Book() {
		BookDao book = bookDao();

		when(bookRepositoryMock.save(any(BookDao.class))).thenReturn(book);

		BookDao bookdaoMock = bookRepositoryMock.save(book);
		assertThat(bookdaoMock.getAuthor()).isNotNull();

		// assertEquals(book, bookServiceImpl.updateBook(anyString()));

	}

	@Test
	public void deleteBookby_d() {
		BookDao deleted = bookDao();
		bookRepositoryMock.delete(deleted);
		assertThat(deleted.getAuthor()).isNotNull();

	}

	private BookDao bookDetails(Book bookRequest) {
		BookDao book = new BookDao();

		book.setId(bookRequest.getId());
		book.setName(bookRequest.getName());
		book.setAuthor(bookRequest.getAuthor());
		book.setDescription(bookRequest.getDescription());
		book.setType(bookRequest.getType());
		book.setPrice(bookRequest.getPrice());
		book.setName(bookRequest.getName());
		return book;
	}

	private BookDao bookDao() {
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

	private List<BookDao> bookDaoDetails() {
		List<BookDao> dao = new ArrayList<>();
		BookDao book = new BookDao();
		book.setId(ID);
		book.setName(NAME);
		book.setAuthor(AUTHOR);
		book.setDescription(DESCRIPION);
		book.setType(TYPE);
		book.setPrice(price);
		book.setName(NAME);
		dao.add(book);
		return dao;
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
