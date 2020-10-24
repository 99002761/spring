package com.bookapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="book")
@TypeAlias("Book")
public class Book {
	
String author;
String category;
@Id
Integer bookId;
String title;
double price;

public Book(String author, String category, Integer bookId, String title, double price) {
	super();
	this.author = author;
	this.category = category;
	this.bookId = bookId;
	this.title = title;
	this.price = price;
}

public Book() {
	super();
	// TODO Auto-generated constructor stub
}

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Integer getBookId() {
	return bookId;
}
public void setBookId(Integer bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [author=" + author + ", category=" + category + ", bookId=" + bookId + ", title=" + title + ", price="
			+ price +"]";
}
}
