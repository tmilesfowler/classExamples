package com.book.service;

import com.book.entity.Book;

public interface BookService {

	public void createBook(Book Book);
	public Book getBookById(int BookId);
	public void updateBookById(int Book,int price);
	public void deleteBookById(Integer BookId);
	
}
