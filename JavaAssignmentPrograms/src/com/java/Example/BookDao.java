package com.java.Example;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	public List<Book> getBook() {
		List<Book> books=new ArrayList<>();
		books.add(new Book(101,"coreJava",400));
		books.add(new Book(102,"advJava",450));
		books.add(new Book(103,"python",500));
		books.add(new Book(104,"deveops",1000));
		books.add(new Book(105,"testing",250));
		return books;
	}

}
