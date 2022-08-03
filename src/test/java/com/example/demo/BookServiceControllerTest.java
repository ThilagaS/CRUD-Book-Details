package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.book.demo.Book.Book;
import com.book.demo.controller.BookController;
import com.book.demo.dao.BookDao;
import com.book.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest({BookController.class})
public class BookServiceControllerTest {
	@Autowired
    private MockMvc mockMvc;

	private static final String ID = "1";
	private static final String NAME = "Science";
	private static final String AUTHOR = "Mark";
	private static final String DESCRIPION = "Science book";
	private static final String TYPE = "Friction";
	private static final Double price = 200d;

    @MockBean
    BookService bookService;
    @Test
    public void save() throws Exception {

        BookDao book = bookDao();
        when(bookService.findBookById(Mockito.any())).thenReturn(book);
       
        mockMvc.perform(
                MockMvcRequestBuilders.post("/book")
                        .content(asJsonString(book))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
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

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
