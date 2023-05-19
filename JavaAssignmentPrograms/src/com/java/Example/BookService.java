package com.java.Example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {

	public List<Book> getBooksInSort() {
		List<Book> book = new BookDao().getBook();

		Collections.sort(book, (Book o1, Book o2)-> 
				 o1.getName().compareTo(o2.getName()));

		return book;
	}

	public static void main(String[] args) {
		System.out.println(new BookService().getBooksInSort());
	}
}

//class MyComparator implements Comparator<Book>{
//
//	@Override
//	public int compare(Book o1, Book o2) {
//		return o1.getPages().compare(o2.getPages());
//	}
//	
