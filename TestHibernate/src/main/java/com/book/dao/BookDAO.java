package com.book.dao;

import com.book.entity.Book;

public interface BookDAO {

	public void addBook(Book book);
	public Book fetchBookById(int bookId);
	public void deleteBookById(int bookId);
	void updateBookByID(int BookId, int price);
	
}
