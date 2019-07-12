package com.book.service;

import com.book.dao.BookDAOImpl;
import com.book.entity.Book;

public class BookServiceImpl implements BookService{

	@Override
	public void createBook(Book book) {
		new BookDAOImpl().addBook(book);
	}

	@Override
	public Book getBookById(int BookId) {
		
		return new BookDAOImpl().fetchBookById(BookId);
	}

	@Override
	public void updateBookById(int Book, int price) {
		// TODO Auto-generated method stub
		new BookDAOImpl().updateBookByID(Book, price);
	}

	@Override
	public void deleteBookById(Integer BookId) {
		// TODO Auto-generated method stub
		new BookDAOImpl().deleteBookById(BookId);
	}

	
	
}
