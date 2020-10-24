package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface BookService {
	Book addBook(Book book);
	boolean deleteBook (Integer bookid) throws BookNotFoundException;
	Book getBookById(Integer bookid) throws BookNotFoundException;
	Book updateBook(Book book);
	List<Book> getAllBooks();
	List<Book> getbyAuthor(String author) throws BookNotFoundException;
	List<Book> getByCategory(String category) throws BookNotFoundException;

	List<Book> getBookbyAuthor(String author) throws BookNotFoundException;
	List<Book> getBookByCategory(String category) throws BookNotFoundException;
	List<Book> findBookByTitleAndPrice(String title,Double price);
	List<Book>findByTitleAndAuthor(String title,String author);

}
