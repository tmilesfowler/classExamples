package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REVATURE_DB")
public class Book {

	@Id
	@Column(name="B_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="B_TITLE", length=50)
	private String title;
	
	@Column(name="B_PRICE")
	private int price;
	
	@Column(name="B_AUTHOR", length=50)
	private String author;
	
	public Book(int id, String title, String author, int price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
	}
	
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public Book() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + "]";
	}
	
	
	
}
