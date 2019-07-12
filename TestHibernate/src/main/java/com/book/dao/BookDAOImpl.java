package com.book.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.book.config.HibernateUtil;
import com.book.entity.Book;

public class BookDAOImpl implements BookDAO{
	
	public void addBook(Book book) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			int id = (int)session.save(book);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Book fetchBookById(int bookId) {
		// TODO Auto-generated method stub
		//Book book = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Book book = session.get(Book.class, bookId);
			System.out.println("Book Id was:" + bookId + "Object is " + book.getTitle());
			if(book != null) {
				return book;
			} else {
				System.out.println("Book doesn't exist with provided Id");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void deleteBookById(int BookId) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Book Book = session.get(Book.class, BookId);
			if(Book != null) {
				session.beginTransaction();
				System.out.println(Book);
				session.delete(Book);
				session.getTransaction().commit();
			} else {
				System.out.println("Book with ID doesn't exist");
			}
		} catch (HibernateException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateBookByID(int BookId, int price) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			System.out.println("Book to be updated: " + BookId);
			Book book = session.get(Book.class, BookId);
			if(book != null) {
				book.setPrice(price);
				session.beginTransaction();
				System.out.println("Book updated: " + book);
				session.update(book);
				session.getTransaction().commit();
			}else {
				System.out.println("Book doesn't exist");
			}
		} catch (HibernateException e) {
			e.getStackTrace();
		}
	}

}
