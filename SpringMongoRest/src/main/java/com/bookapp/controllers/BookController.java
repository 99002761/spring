package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;

//@RestController
//@RequestMapping("/book-api")
public class BookController {
	@Autowired
	BookService bookService;
@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
	return bookService.addBook(book);
}
@DeleteMapping("/books/delete-one/{bookId}")
public boolean deleteBook(@PathVariable("bookId")Integer bookid) throws BookNotFoundException{
	return bookService.deleteBook(bookid);
}
@GetMapping("/books/get-one/{bookId}")
public Book getBookById(@PathVariable("bookId")Integer bookid) throws BookNotFoundException {
	return bookService.getBookById(bookid);
	
}
@PutMapping("/books/update-one")
Book updateBook(Book book) throws BookNotFoundException{
	return bookService.updateBook(book);
}
@GetMapping("/books")
List<Book> getAllBooks(){
	return bookService.getAllBooks();
}
@GetMapping("/books/author/{author}")
public List<Book> getbyAuthor(@PathVariable("author")String author) throws BookNotFoundException{
	return bookService.getbyAuthor(author);
}
@GetMapping("/books/category/{category}")
public List<Book> getbyCategory(@PathVariable("category")String category) throws BookNotFoundException{
	return bookService.getByCategory(category);
}

@GetMapping("/books/titleauthor/{title}/{author}")
public List<Book> findByTitleAndAuthor(@PathVariable("title")String title,@PathVariable("author")String author) {
	return bookService.findByTitleAndAuthor(title,author);
}
@GetMapping("/books/titleprice/{title}/{price}")
public List<Book> findBookByTitleAndPrice(@PathVariable("title")String title,@PathVariable("price")Double price) {
	return bookService.findBookByTitleAndPrice(title,price);
}

}

